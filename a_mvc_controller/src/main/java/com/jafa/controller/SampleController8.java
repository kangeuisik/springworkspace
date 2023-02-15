package com.jafa.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.ApplicationFormVO;


//applcationFormVO
@Controller
@RequestMapping("/sample08")
public class SampleController8 {
	
	//쿠키생성
	@GetMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
		//쿠키생성
		Cookie cookie1 = new Cookie("spring", "spring5.0");
		Cookie cookie2 = new Cookie("jsp", "jsp2.3");//공백안됨 넣으려면 인코딩
		
		//유효시간
		cookie1.setMaxAge(60*60);
		cookie2.setMaxAge(60*60);
		
		//response 객체 보관소 추가
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "/sample08/setCookie";
	}
	//모든쿠키 확인
	@GetMapping("/getCookie")
	public String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				System.out.println("쿠키이름" + c.getName());
				System.out.println("쿠키값"+c.getValue());
			}
		}
		return "/sample08/getCookie";
	}
	// 특정이름을 가지는 쿠키 얻기
	@GetMapping("/getCookieByName")
	public String getCookieByName(HttpServletRequest request,String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			if(cookies!=null) {
				for(Cookie c : cookies) {
					if(c.getName().equals(name)) {
						return "sample08/getCookieByName";
				}		
			}
		}
	}
	return "/sample08/other";
		
	}
	//모든쿠키 삭제
	@GetMapping("/delAllCookies")
	public String delAllCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

			for(Cookie c : cookies) {
			c.setMaxAge(0);
			response.addCookie(c);
			}
		return "/sample08/afterDelAll";
	}

	//특정 쿠키 삭제
	@GetMapping("/delCookies")
	public String delCookies(String name, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				if(c.getName().equals(name)) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		return "/sample08/afterDel";
	}
}
