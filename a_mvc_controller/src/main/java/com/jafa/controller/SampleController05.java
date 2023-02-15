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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.domain.MemberDTO;

//커맨드 객체
@Controller
@RequestMapping("/sample05")
public class SampleController05 {
	
	@RequestMapping("/register")
	public String registerForm() {
		return"sample05/registerForm";
	}
	//요청 파라미터 값을 커맨드 객체의 프로퍼티에 저장할 경우 setter메소드 이용
	//
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberDTO memberDTO) {
		//커맨드 객체 : 참조타입(기본형과 기본형의 래퍼타입 제외)이 파라미터로 선언
		//Model 에 추가하지않고 뷰페이지에서 사용할 수 있다.
		// 뷰페이지에서 사용되는 이름은 memberDTO(타입의 첫글자 소문자 변경)
		System.out.println(memberDTO);
		return "sample05/registerResult";
		
	}

}
