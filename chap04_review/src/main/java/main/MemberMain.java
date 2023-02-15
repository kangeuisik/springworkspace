package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppContext;
import spring.MemberDao;
import spring.MemberService;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberService service = ctx.getBean("memberSvc",MemberService.class);
	
		service.register();
	}
}
