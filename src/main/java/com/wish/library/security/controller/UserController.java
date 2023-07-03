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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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
            log.info("index page, security 조회 email : " + email);
            UserDTO user = (UserDTO) customUserService.loadUserByUsername(email);
            user.setPassword(null);
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberSaveForm memberSaveForm, Model model) {
        log.info("=================join Controller");
        try{
            memberService.save(memberSaveForm);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "join";
        }
        return "redirect:/login";
        /*return new ResponseEntity<>("회원 가입 완료", HttpStatus.OK);*/
    }

}
