package chpa02_review;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chpa02_review.AppContext;

public class MainSpring {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberDao dao = ctx.getBean("memberDao",MemberDao.class);
		dao.greeting();
	}
}
