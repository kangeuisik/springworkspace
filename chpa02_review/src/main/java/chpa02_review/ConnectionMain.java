package chpa02_review;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConnectionMain {
	public static void main(String[] args) {
		ConnectionUtil util = new ConnectionUtil();
		//Setter Injection
		util.setDriver("com.oracle.com");
		util.setUrl("localhost:8080");
		util.setUsername("scott");
		util.setPassword("tiger");
		util.connectionInfo();
		System.out.println();
//		====================================================================
//		java 설정
//		AnnotationConfigApplicationContext ctx =
//				new AnnotationConfigApplicationContext(AppContext.class);
//		====================================================================
		//xml설정
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:AppCtx.xml");
		
		ConnectionUtil bean = ctx.getBean("connectionUtil",ConnectionUtil.class);
		
		bean.connectionInfo();
		
		
		
		
	}
}
