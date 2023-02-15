package com.jafa.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.ApplicationFormVO;

@Controller
@RequestMapping("/sample09")
public class SampleController9 {
	
	//쿠키생성
	@GetMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
		//쿠키생성
		Cookie cookie1 = new Cookie("spring", "spring5.0");
		Cookie cookie2 = new Cookie("jsp", "jsp2.3");//공백안됨 넣으려면 인코딩
		Cookie cookie3 = new Cookie("servlet", "3");
		//유효시간
		cookie1.setMaxAge(60*60);
		cookie2.setMaxAge(60*60);
		cookie3.setMaxAge(60*60);
		
		//response 객체 보관소 추가
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		return "/sample09/setCookie";
	}
	//MissingRequestCookieException 쿠키값이 없는경우 발생
	@GetMapping("/getCookie")
	public String getCookie(@CookieValue("spring") Cookie cookie) {
		if(cookie!=null) {
		System.out.println("쿠키이름"+cookie.getName());
		System.out.println("쿠키 값"+cookie.getValue());
		}
		return "/sample09/getCookie";	
	}

	@GetMapping("/requiredGetCookie")
	public String requiredGetCookie(@CookieValue(value = "spring", required=false) Cookie cookie) {
		if(cookie!=null) {
		System.out.println("쿠키이름"+cookie.getName());
		System.out.println("쿠키 값"+cookie.getValue());
		}
		return "/sample09/requiredGetCookie";	
	}
	// cookie 객체 대신 쿠키값에 해당되는 타입을 바로 사용할수 있다
	@GetMapping("/getCookieValue")
	public String getCookieValue(@CookieValue("spring") String springValue) {
		System.out.println(springValue);
		return "/sample09/getCookieValue";
	}
	@GetMapping("/getCookieValue2")
	public String getCookieValue2(@CookieValue("servlet") Integer servletVersion) {
		System.out.println(servletVersion);
		return "/sample09/getCookieValue2";
	}

	//해당 쿠키 이름이 존재하지 않는 경우 defaultValue속성으로 기본값 지정 가능
	@GetMapping("/getCookieValue3")
	public String getCookieValue3(@CookieValue(value = "servlet", defaultValue = "4") Integer servletVersion) {
		System.out.println(servletVersion);
		return "/sample09/getCookieValue3";
	} 
}
