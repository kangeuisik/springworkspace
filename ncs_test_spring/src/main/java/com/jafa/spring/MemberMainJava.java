package com.jafa.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jafa.config.RootConfig;
import com.jafa.repository.MemberRepository;

public class MemberMainJava {
	public static void main(String[] args) {
		ApplicationContext ctx 
		= new AnnotationConfigApplicationContext(RootConfig.class);
		
		MemberRepository memberRepository = ctx.getBean(MemberRepository.class);
		memberRepository.findByName();
	}
}
