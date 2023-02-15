package com.jafa.example05;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class JdbcConnector05 implements EnvironmentAware{

	
	// EnvironmentAware 인터페이스를 구현한 객체가 스프링빈으로 등록되면
	//스프링 컨테이너는 이 빈에 Environment객체를 주입해준다
	
	private Environment env;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	public void JdbcInfo() {
		System.out.println("드라이버 : "+env.getProperty("db.driver"));
		System.out.println("url : "+env.getProperty("db.url"));
		System.out.println("사용자계정 : "+env.getProperty("db.username"));
		System.out.println("비밀번호 : "+env.getProperty("db.password"));
	}
}
