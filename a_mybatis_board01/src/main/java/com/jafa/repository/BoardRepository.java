package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	
	//게시물 조회
	List<BoardVO> findAll();
	
	//게시물 상세
	BoardVO detail(Long bno);
	
	//게시물 작성
	void save(BoardVO vo);
	
	//게시물 삭제 
	void delete(Long bno);
	
	//게시물 수정
	void update(BoardVO vo);

	
}
