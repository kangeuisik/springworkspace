package com.jafa.dao;

import com.jafa.domain.MemberVO;

public interface MemberDao {
	
	MemberVO findByMno(Long memberNo);
}
