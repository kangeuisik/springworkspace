package com.jafa.repository;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.MemberVO;

public interface AccountRepository {
	
	MemberVO memberCheck(MemberVO vo); //이름과 게좌로 확인
	
	void adjustPoint(@Param("m") MemberVO vo,@Param("amount") int amount); //파라미터가 두개이상일때 반드시 @Param으로 명시 
}
