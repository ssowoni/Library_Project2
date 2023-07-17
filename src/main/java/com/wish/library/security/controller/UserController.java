package com.wish.library.security.controller;

import com.wish.library.security.controller.validation.CheckEmailValidator;
import com.wish.library.security.controller.validation.CheckNicknameValidator;
import com.wish.library.security.controller.validation.CheckPasswordValidator;
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
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * GET 방식, 화면 조회시
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CustomUserService customUserService;
    private final MemberService memberService;
    private final CheckEmailValidator checkEmailValidator;
    private final CheckNicknameValidator checkNicknameValidator;
    private final CheckPasswordValidator checkPasswordValidator;


    /*커스텀 유효성 검증을 위해 추가*/
    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkEmailValidator);
        binder.addValidators(checkNicknameValidator);
        binder.addValidators(checkPasswordValidator);
    }



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
                        , RedirectAttributes rttr
                        ,Model model) {
        log.info("=================join Controller");

        if(bindingResult.hasErrors()){
            model.addAttribute("memberDto", memberSaveForm);
            log.info("errors={}", bindingResult);

            /*중복 검사 통과 못한 메시지를 핸들링*/
/*            Map<String, String> validatorResult = memberService.validateHandling(bindingResult);
            //keySet() : Map의 key값을 가져올때 사용.
            for(String key:validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }*/

            return "join";
        }

        /*if(!(memberSaveForm.getPassword().equals(memberSaveForm.getPasswordConfirm()))){
            model.addAttribute("memberDto", memberSaveForm);
            bindingResult.rejectValue("passwordConfirm","passwordInCorrect","2개의 비밀번호가 일치하지 않습니다.");
            log.info("errors={}", bindingResult);
            return "join";
        }*/


        boolean saveResult = memberService.save(memberSaveForm);
        if(saveResult){
            rttr.addFlashAttribute("result", "회원 가입 완료");
            return "redirect:/login";
        }
            return "join";
    }


}
