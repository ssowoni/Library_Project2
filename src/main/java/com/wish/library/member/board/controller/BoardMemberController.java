package com.wish.library.member.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member")
public class BoardMemberController {

    @GetMapping("/board")
    public String board(){
        return "board/list";
    }
}
