package com.jafa.example02;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

//environment, propertySource 추가하기 코드로 추가할때
public class PropertySourceExample02 {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		
	ConfigurableEnvironment env = ctx.getEnvironment();
	
	//PropertySources를 등록하는 메소드 제공
	MutablePropertySources propertySources = env.getPropertySources();
	
	//프로퍼티 파일등록
	//우선순위 first- last
	//propertySources.addFirst(new ResourcePropertySource("classpath:/example02/oracle.properties"));
	propertySources.addLast(new ResourcePropertySource("classpath:/example02/mysql.properties"));
	
	String driver = env.getProperty("db.driver");
	String url = env.getProperty("db.url");
	String name = env.getProperty("db.username");
	String pwd = env.getProperty("db.password");
	
	System.out.println(driver);
	System.out.println(url);
	System.out.println(name);
	System.out.println(pwd);
	
	}
}
