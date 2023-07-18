package com.wish.library.board.service;

import com.wish.library.board.domain.ProBoardVO;
import com.wish.library.board.mapper.ProBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProBoardServiceImpl implements ProBoardService{

    private final ProBoardMapper mapper;

    public List<ProBoardVO> readList(){
        log.info("=======  proBoard list all, service");
        return mapper.getList();
    }

}
