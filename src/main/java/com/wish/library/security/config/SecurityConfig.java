package com.wish.library.security.config;

import com.wish.library.security.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final DataSource dataSource;
    private final CustomUserService customUserService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.csrf()
                .disable();

        //권한에 따라 허용하는 url 설정
        http.authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/","/login","/join").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/member/**").hasRole("USER")
                .anyRequest().authenticated(); // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야만 접근 가능

        //login 설정
        http.formLogin()
                .loginPage("/login") // GET 요청 (login form을 보여줌)
                .loginProcessingUrl("/login") //POST 요청 (login 창에 입력한 데이터를 처리)
                .usernameParameter("email") //login에 필요한 id 값을 email로 설정 (default는 username)
                .passwordParameter("password") //login에 필요한 password 값을 password
                .defaultSuccessUrl("/"); //login에 성공하면 /로 redirect

        //logout 설정
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me","JSESSIONID"); //logout에 성공하면 /로 redirect

        //자동 로그인 설정
        http.rememberMe()
                .key("wish") //쿠키에 사용되는 값을 암호화하기 위한 키(key)값
                .tokenRepository(persistentTokenRepository())
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(604800); //토큰 유지 시간(초단위)- 일주일


        return http.build();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }


}
