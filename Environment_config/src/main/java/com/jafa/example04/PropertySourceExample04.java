package com.jafa.example04;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jafa.example03.JdbcConnector;

import config.AppConfig4;

//environment, propertySource 추가하기 코드로 추가할때
public class PropertySourceExample04 {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig4.class);
		
		JdbcConnector bean = ctx.getBean(JdbcConnector.class);
		System.out.println(bean);
	
	}
}
