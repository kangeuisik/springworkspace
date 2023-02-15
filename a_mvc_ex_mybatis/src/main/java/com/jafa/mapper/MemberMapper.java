package com.jafa.mapper;

import com.jafa.domain.MemberVO;

public interface MemberMapper {

    MemberVO findByMno(Long mno);
}
