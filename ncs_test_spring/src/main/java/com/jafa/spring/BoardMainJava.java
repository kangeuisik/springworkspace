package com.jafa.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jafa.config.RootConfig;
import com.jafa.repository.MemberRepository;
import com.jafa.service.BoardService;

public class BoardMainJava {
	
	public static void main(String[] args) {
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(RootConfig.class);
		BoardService boardService = ctx.getBean(BoardService.class);
		boardService.list();
	}
}
