package com.wish.library.security.config;

import com.wish.library.security.domain.UserDTO;
import com.wish.library.security.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAuthProvider implements AuthenticationProvider {

    private final CustomUserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String reqEmail = (String) authentication.getPrincipal().toString(); // 로그인 창에 입력한 email
        String reqPassword = (String) authentication.getCredentials().toString(); //로그인 창에 입력한 password
        UserDTO userDTO = (UserDTO)userService.loadUserByUsername(reqEmail);
        log.info("로그인시 조회해온 정보={}",userDTO.toString());

        //matches : 암호화되지 않은 비밀번호와 암호화된 비밀번호가 일치하는지 비교
        if(!passwordEncoder.matches(reqPassword, userDTO.getPassword())){
            log.info("비밀번호가 일치하지 않습니다.");
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        log.info("비밀번호 일치합니다. 로그인 완료 ");
        return new UsernamePasswordAuthenticationToken(reqEmail, null, userDTO.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
