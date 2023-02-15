package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jafa.domain.BoardVO;

@Controller
public class HomeController {
	@GetMapping("/")
	public String Home(Model model) {
		model.addAttribute("board", new BoardVO());
		return "index";
	}
}
