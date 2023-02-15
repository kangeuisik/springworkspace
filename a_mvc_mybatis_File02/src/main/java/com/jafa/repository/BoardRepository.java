package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {

	void write(BoardVO vo);
	//첨부파일 개수 업데이트
	void updateAttachFileCnt(Long bno);
	
	List<BoardVO> list();
	
	BoardVO detail(Long bno);
	
	void remove(Long bno);
	//수정 안의 내용 수정처리
	void modify(BoardVO vo); 

}
