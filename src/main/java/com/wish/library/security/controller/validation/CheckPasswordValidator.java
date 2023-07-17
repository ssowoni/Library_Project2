package com.wish.library.security.controller.validation;

import com.wish.library.security.domain.MemberSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@Slf4j
public class CheckPasswordValidator extends AbstractValidator<MemberSaveForm> {

    @Override
    protected void doValidate(MemberSaveForm dto, Errors errors) {
        log.info("닉네임 중복체크 중");
        if (!(dto.getPassword().equals(dto.getPasswordConfirm()))) {
            errors.rejectValue("passwordConfirm", "passwordInCorrect", "2개의 비밀번호가 일치하지 않습니다.");
        }
    }
}
