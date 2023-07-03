package com.wish.library.security.service;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
