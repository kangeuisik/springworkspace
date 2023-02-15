package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	//alias 사용
	List<BoardVO> list();
	BoardVO detail(Long bno);
	
	//resultMap 사용
	List<BoardVO> list2();
	BoardVO detail2(Long bno);
	
	//자동생성 키 받기
	void save(BoardVO vo);
}
