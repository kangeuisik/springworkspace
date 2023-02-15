package com.jafa.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.domain.MemberDTO;
import com.jafa.domain.StudentVO;

//
@Controller
@RequestMapping("/sample06")
public class SampleController6 {
	
	@GetMapping("/report")
	public String reportForm() {
		return"/sample06/reportForm";
	}
	//studentVO reportVO
	@PostMapping("/report")
	public String report(StudentVO vo) {
		System.out.println(vo);
		return "/sample06/reportResult";
		
	}

}
