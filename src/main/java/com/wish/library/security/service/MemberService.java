package com.wish.library.security.service;

import com.wish.library.security.domain.MemberSaveForm;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {

    boolean save(MemberSaveForm member);

    boolean checkEmailDuplication(String email);

    boolean checkNicknameDuplication(String nickname);

    Map<String, String> validateHandling(Errors errors);

}
