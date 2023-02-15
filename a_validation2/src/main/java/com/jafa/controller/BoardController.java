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

import com.jafa.domain.BoardDTO;
import com.jafa.validation.BoardDTOValidation;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@GetMapping("/write")
	public String write(BoardDTO dtd) {
		return "/board/writeForm";
	}
	
	@PostMapping("/write")
	public String writeForm(@Valid BoardDTO dto, Errors errors, 
			RedirectAttributes rttr) {
		if(errors.hasErrors()) {
			System.out.println("error");
			return "/board/writeForm";
		}
		log.info(dto);
		return "redirect:/board/write";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardDTOValidation());
	}
}
