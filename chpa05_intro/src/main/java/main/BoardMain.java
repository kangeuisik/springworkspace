package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import kr.co.spring.BoardService;

public class BoardMain {
	public static void main(String[] args) {
		
	
	AnnotationConfigApplicationContext ctx = 
			new AnnotationConfigApplicationContext(AppCtx.class);
	
	BoardService bean = ctx.getBean(BoardService.class);
	bean.write();

	}
}