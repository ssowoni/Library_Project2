package com.wish.library.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProBoardVO {
    /**
     * int, Integer에 비해 숫자의 범위가 넓으며
     * primitive 타입은 null이 될 수 없기 때문에, null 값을 정확히 처리하기 위해 Wrapper 클래스를 사용한다.
     */
    private Long proBno; //게시글 번호
    private String title; //게시글 제목
    private String content; //게시글 내용
    private String writer; //게시글 작성자
    private int replyCnt; //게시글 댓글 수
    private Date regDate; //게시글 등록일
    private Date updateDate; //게시글 수정일



}
