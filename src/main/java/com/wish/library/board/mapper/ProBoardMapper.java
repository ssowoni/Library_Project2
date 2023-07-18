package com.wish.library.board.mapper;

import com.wish.library.board.domain.ProBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProBoardMapper {

     /*프로그램 게시글 전체 조회*/
     List<ProBoardVO> getList();

     /*단일 게시글 조회 */
     ProBoardVO getOne(Long proBno);
}
