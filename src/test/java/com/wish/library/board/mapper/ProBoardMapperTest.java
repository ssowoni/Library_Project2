package com.wish.library.board.mapper;

import com.wish.library.board.domain.ProBoardVO;
import com.wish.library.board.service.ProBoardService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest

class ProBoardMapperTest {

    @Setter(onMethod_ = @Autowired)
    private ProBoardMapper mapper;


    @Test
    public void 게시글_전체조회_테스트(){
        log.info("mapper ={}", mapper.toString());
        List<ProBoardVO> list = mapper.getList();
        int size = list.size();
        Assertions.assertThat(size).isEqualTo(32);
    }

    @Test
    public void 게시글_하나조회_테스트(){
        log.info("mapper ={}", mapper.toString());
        ProBoardVO one = mapper.getOne(1L);
        Assertions.assertThat(one.getWriter()).isEqualTo("user");
    }

}