package com.jafa.example06;

import org.springframework.context.support.GenericXmlApplicationContext;

//xml프로퍼티 설정
public class UsePropertyByXml {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:springConfig/appConfig6.xml");
	
		JdbcConnector06 bean = ctx.getBean(JdbcConnector06.class);
		System.out.println(bean);
	}
}
