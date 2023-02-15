package com.jafa.dao;

import java.util.List;

import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

public interface MemberDao {
	
	public MemberVO findByMno(Long mno);
}
