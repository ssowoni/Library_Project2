package com.wish.library.security.service;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public boolean save(MemberSaveForm member) {
        log.info("============member save service");
        try{
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            mapper.insert(member);
            return true;
        }catch(Exception e){
            e.printStackTrace();//에러의 발생 근원지를 찾아서 단계별로 에러를 출력
            log.info("MemberService  회원가입 에러 ={}", e.getMessage());
        }
        return false;
    }

    /*회원 가입 시, 유효성 및 중복 검사*/
    @Override
    public boolean checkEmailDuplication(String email) {
        return mapper.getOneByEmail(email);
    }

    @Override
    public boolean checkNicknameDuplication(String nickname) {
        return mapper.getOneByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public Map<String,String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        /*유효성 및 중복 검사에 실패한 필드 목록을 받음*/
        for(FieldError error : errors.getFieldErrors()){
            //String.format은 문자열 형식을 설정할때 사용한다.
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }





}
