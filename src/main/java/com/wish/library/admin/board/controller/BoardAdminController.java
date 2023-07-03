package com.wish.library.admin.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin")
public class BoardAdminController {


    @GetMapping("/board")
    public String board(){
        return "board/list";
    }

}
