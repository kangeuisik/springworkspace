package com.jafa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.MemberDTO;
import com.jafa.validation.MemberDTOValidator;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	//회원가입폼
	@GetMapping("/join")
	public String joinView(MemberDTO dto) {
		return "/member/join";
	}
	//회원가입 처리
	@PostMapping("/join")
	public String join(@Valid MemberDTO dto, Errors errors 
			,RedirectAttributes rttr) {//에러는 검증대상 바로 뒤에 위치..
		if(errors.hasErrors()) {//에러가 있다면
			return "/member/join";
		}
		log.info(dto);
		return "redirect:/";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberDTOValidator());
	}
}
