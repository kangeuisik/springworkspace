package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Category;

public interface BoardRepository {
	//게시판
	List<BoardVO> list(String id);
	
	void write(BoardVO vo);
	
	
	//카테고리
	List<Category> getCateList();

	void saveCate(Category category);
	
	void delCate(String cid);

	
}
