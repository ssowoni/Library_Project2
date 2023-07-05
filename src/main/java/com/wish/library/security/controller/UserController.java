package com.wish.library.security.controller;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.domain.UserDTO;
import com.wish.library.security.service.CustomUserService;
import com.wish.library.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * GET 방식, 화면 조회시
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CustomUserService customUserService;
    private final MemberService memberService;

    @GetMapping("/")
    public String home(Model model){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(email.equals("anonymousUser"))) {
            log.info("index page, security 조회 email, getPrincipal : " + email);
            UserDTO user = (UserDTO) customUserService.loadUserByUsername(email);
            user.setPassword(null);
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model,
            @RequestParam(value="error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception){
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("memberSaveForm") MemberSaveForm memberSaveForm
                        , BindingResult bindingResult
                        , RedirectAttributes rttr) {
        log.info("=================join Controller");

        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return "join";
        }

        boolean saveResult = memberService.save(memberSaveForm);
        if(saveResult){
            rttr.addFlashAttribute("result", "회원 가입 완료");
            return "redirect:/login";
        }
            return "join";


    }

}
