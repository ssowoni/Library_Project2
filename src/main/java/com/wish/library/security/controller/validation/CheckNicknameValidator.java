package com.wish.library.security.controller.validation;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckNicknameValidator extends AbstractValidator<MemberSaveForm> {

    private  final MemberService memberService;

    @Override
    protected void doValidate(MemberSaveForm dto, Errors errors) {
        log.info("닉네임 중복체크 중");
        if(memberService.checkNicknameDuplication(dto.getNickname())) {
            errors.rejectValue("nickname", "닉네임 중복 오류", "이미 사용중인 닉네임입니다.");
        }
    }
}
