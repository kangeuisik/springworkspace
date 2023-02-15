package com.jafa.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	BoardRepository repository;
	
	// list?page=1&perPageNum=20
	// list?page=1
	@GetMapping("/list")
	public String list(@ModelAttribute("cri") Criteria criteria, Model model) {
		log.info(criteria);
		model.addAttribute("p", new Pagination(criteria, repository.getTotalCount()));
		model.addAttribute("list", repository.list(criteria));
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String detail(Long bno,Model model) {
		model.addAttribute("board", repository.detail(bno));
		return "board/detail";
	}
}
