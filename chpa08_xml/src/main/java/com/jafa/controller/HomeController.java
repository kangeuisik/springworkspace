package com.jafa.controller;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Autowired
	DataSource dataSource;
	
	@GetMapping("/")
	public String Home() {
		System.out.println(dataSource);
		return "index";
		
	}
}
