package chpa02_review;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MaingSpringXMl {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:AppCtx.xml"); //경로찾는 접두어 : classpath
		
		MemberDao dao = ctx.getBean("memberDao",MemberDao.class);
		System.out.println(dao);
		dao.greeting("스프링");
	}
}
