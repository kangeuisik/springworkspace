package chpa02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//메인메소드가 greeter 객체를 생성하지않음.
		
		//스프링 컨테이너 생성 후 설정 정보 전달
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		// 스프링 컨테이너가 생성한 스프링빈을 가져옴
		//getBean(빈이름, 빈타입)
		Greeter g = ctx.getBean("greeting",Greeter.class);
		
		System.out.println(g.greet("스프링"));
		ctx.close();
		
	}
}

