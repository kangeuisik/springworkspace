package com.jafa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

public interface BoardRepository {
	
	//게시물 조회
	List<BoardVO> findAll( // 변수가 2개이상일때만 @param 붙여야함
			@Param("type") String type,
			@Param("keyword") String keyword);
	
	List<BoardVO> findAll2(Criteria criteria);
	
}
