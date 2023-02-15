package jafa.com.example03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig3;

public class MessageSourceExample03 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig3.class);

		LoginResult bean = ctx.getBean(LoginResult.class);
		bean.failLogin();
		bean.successLogin("손흥민");
	}
}
