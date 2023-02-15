package com.jafa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.BoardVO;

public interface BoardRepository {

	
	List<BoardVO> boardList();

	void delAllSelected(@Param("bnoList") String[] bnoArray);
	//배열로 전달할때는 파람 반드시 붙여줘야함.
	
	
}
