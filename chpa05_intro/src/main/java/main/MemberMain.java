package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppContext;
import spring1.MemberService;

public class MemberMain {
	
	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	
	MemberService bean = ctx.getBean(MemberService.class);
	bean.register();
	
	}
}
