package com.jafa.example05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig5;

public class EnvironmentAwareMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig5.class);
		
		JdbcConnector05 bean = ctx.getBean(JdbcConnector05.class);
		bean.JdbcInfo();
	
	}
}
