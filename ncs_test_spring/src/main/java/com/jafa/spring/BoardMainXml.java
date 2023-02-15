package com.jafa.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jafa.repository.MemberRepository;
import com.jafa.service.BoardService;

public class BoardMainXml {
	public static void main(String[] args) {
		ApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:app-context.xml");
		
		BoardService boardService = ctx.getBean(BoardService.class);
		boardService.list();
	}
}
