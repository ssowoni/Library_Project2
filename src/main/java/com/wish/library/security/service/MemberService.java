package com.wish.library.security.service;

import com.wish.library.security.domain.MemberSaveForm;

public interface MemberService {

    boolean save(MemberSaveForm member);
}
