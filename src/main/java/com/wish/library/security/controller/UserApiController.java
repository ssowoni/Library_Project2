package com.wish.library.security.controller;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * POST, PUT, DELETE 요청 처리시
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserApiController {

    private final MemberService service;


}
