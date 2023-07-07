package com.wish.library.security.mapper;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     /*로그인 정보 조회*/
     UserDTO getOne(String email);

     /*회원가입*/
     int insert(MemberSaveForm member);

     /*중복 검사, 이메일 조회*/
     boolean getOneByEmail(String email);

     /*중복 검사, 닉네임 조회*/
     boolean getOneByNickname(String nickname);


}
