package com.jafa.example01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentExample01 {
	
	//시스템 프로퍼티 읽기
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment(); //개발환경에 대한 정보를 얻을수 있음
		
		String javaVersion = env.getProperty("java.version");
		String javaHome = env.getProperty("java.home");
		String osName = env.getProperty("os.name");
		String pathSeperator = env.getProperty("file.separator");
		System.out.println(javaVersion);
		System.out.println(javaHome);
		System.out.println(osName);
		System.out.println(pathSeperator);
		

		
		
	}
}
