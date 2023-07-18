package com.wish.library.board.controller;

import com.wish.library.board.domain.ProBoardVO;
import com.wish.library.board.service.ProBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 프로그램 게시판 - 관리자
 */

@Controller
@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ProBoardAdminController {

    private final ProBoardService service;

    @GetMapping("/board")
    public String board(Model model){
        log.info("=======  proBoard list all, controller");
        List<ProBoardVO> boardList = service.readList();
        model.addAttribute("list", boardList);
        return "board/program/list";
    }

}
