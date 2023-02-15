package com.jafa.example03;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import config.AppConfig3;

//environment, propertySource 추가하기 코드로 추가할때
public class PropertySourceExample03 {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		
		JdbcConnector bean = ctx.getBean(JdbcConnector.class);
		System.out.println(bean);
	
	}
}
