package com.wish.library.security.controller.validation;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckEmailValidator extends AbstractValidator<MemberSaveForm> {

    private  final MemberService memberService;

    @Override
    protected void doValidate(MemberSaveForm dto, Errors errors) {
        log.info("이메일 중복체크 중");
        if(memberService.checkEmailDuplication(dto.getEmail())) {
            errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일입니다.");
        }
    }
}
