package com.jafa.controller;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { // 스프링빈이 될수 있음
	@Autowired
	DataSource dataSource;
	
	
	
	//localhost:8090/chap08/
	@GetMapping("/")
	public String Home() {
		System.out.println(dataSource);
		return "index"; //WEB-INF/views/index.jsp
	}

	
	
}
