package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//스프링 컨테이너 생성, 빈 설정정보 전달
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Greeter g = ctx.getBean("greeter",Greeter.class);
		System.out.println(g.greet("강의식"));
	}
}
