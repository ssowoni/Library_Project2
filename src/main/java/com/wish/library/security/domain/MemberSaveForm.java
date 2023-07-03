package com.wish.library.security.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor //기본 생성자를 생성해준다.
@Builder
public class MemberSaveForm {

    private String email; // 회원 아이디
    private String password; //비밀번호
    private String name;
    private String nickname;
    private Sex mfCode; //성별 (men, female)
    private String cellNo;

}
