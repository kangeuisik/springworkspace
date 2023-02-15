package com.jafa.dao;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardDao {
	List<BoardVO> findByWriter(String writer);
}
