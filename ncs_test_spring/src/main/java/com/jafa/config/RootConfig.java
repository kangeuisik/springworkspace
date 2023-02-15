package com.jafa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.jafa.repository.BoardRepository;
import com.jafa.repository.MemberRepository;
import com.jafa.service.BoardService;

 
@Configuration
public class RootConfig {
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemberRepository(); 
	}

	@Bean
	public BoardRepository boardRepository() {
		return new BoardRepository(); 
	}
	
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setBoardRepository(boardRepository());
		return boardService;
	}
	
}
