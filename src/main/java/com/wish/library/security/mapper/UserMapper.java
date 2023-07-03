package com.wish.library.security.mapper;

import com.wish.library.security.domain.MemberSaveForm;
import com.wish.library.security.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     UserDTO getOne(String email);

     int insert(MemberSaveForm member);
}
