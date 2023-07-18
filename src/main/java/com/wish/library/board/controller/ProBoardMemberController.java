package com.wish.library.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 프로그램 게시판 - 회원
 */

@Controller
@Slf4j
@RequestMapping("/member")
public class ProBoardMemberController {

    @GetMapping("/board")
    public String board(){
        return "board/program/list";
    }
}
