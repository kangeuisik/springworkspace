package chpa02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain2 {
	public static void main(String[] args) {

		

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeting",Greeter.class);
		Greeter g2 = ctx.getBean("greeting",Greeter.class);
		
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(g1==g2);
		ctx.close();
		
	}
}

