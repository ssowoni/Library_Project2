package com.wish.library.security.service;

import com.wish.library.security.domain.UserDTO;
import com.wish.library.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("=========== security UserDetailsService");
        UserDTO user = mapper.getOne(email);
        if(user==null) throw new UsernameNotFoundException("Not Found User");
        return user;
    }
}
