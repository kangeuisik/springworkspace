package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.Criteria;
import com.jafa.domain.Pagination;
import com.jafa.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardRepository repository;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("cri") Criteria criteria, Model model) {
		model.addAttribute("list", repository.list(criteria));
		model.addAttribute("p",
				new Pagination(criteria, repository.getTotalCount(criteria)));
		return "board/list";
	}
	@GetMapping("/detail")
	public String detail(Long bno, Model model) {
		model.addAttribute("b", repository.detail(bno));
		return "board/detail";
	}

}
