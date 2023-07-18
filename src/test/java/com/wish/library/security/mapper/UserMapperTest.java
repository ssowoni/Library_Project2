package com.wish.library.security.mapper;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.domain.Sex;
import com.wish.library.security.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j

class UserMapperTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void 비밀번호_인코더_테스트(){

        //given
        String password = "admin";
        String enPw = passwordEncoder.encode(password);
        log.info("인코더한 비먼 ={}",enPw);
        //when,then
        boolean matchResult = passwordEncoder.matches(password, enPw);
        Assertions.assertThat(matchResult).isEqualTo(true);
    }


    @Test
    public void 회원가입_테스트(){

        MemberSaveForm member = MemberSaveForm.builder()
                .email("test1@gmail.com")
                .password(passwordEncoder.encode("test"))
                .name("test회원")
                .nickname("test회원")
                .mfCode(Sex.FEMALE)
                .cellNo("01077778888")
                .build();


        int insertResult = userMapper.insert(member);
        Assertions.assertThat(insertResult).isEqualTo(1);

       /* boolean saveResult = memberService.save(member);
        Assertions.assertThat(saveResult).isEqualTo(true);*/
    }

    @Test
    public void 회원가입_이메일_중복테스트(){
        MemberSaveForm member = MemberSaveForm.builder()
                .email("test@gmail.com")
                .password(passwordEncoder.encode("test"))
                .name("test회원")
                .nickname("test회원")
                .mfCode(Sex.FEMALE)
                .cellNo("01077778888")
                .build();



    }


}