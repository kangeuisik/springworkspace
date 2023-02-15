package com.jafa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jafa.domain.BoardVO;

@Repository
public class BoardDao {
	
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new BoardVO("제목01","작성자01"));
		list.add(new BoardVO("제목02","작성자02"));
		list.add(new BoardVO("제목03","작성자03"));
		list.add(new BoardVO("제목04","작성자04"));
		list.add(new BoardVO("제목05","작성자05"));
		return list;
	}
}
