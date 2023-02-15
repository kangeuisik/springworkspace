package com.jafa.service;

import com.jafa.repository.BoardRepository;

public class BoardService {
	
	BoardRepository boardRepository;

	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	} 
	
	public void list() {
		boardRepository.selectAll();
	}
}
