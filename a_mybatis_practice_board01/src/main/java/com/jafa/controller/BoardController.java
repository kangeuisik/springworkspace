package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;
import com.jafa.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	@Autowired
	BoardRepository repository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Criteria criteria, Model model) {
		model.addAttribute("list",repository.list(criteria));
		return "board/list";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	Long detail(BoardVO vo, Long bno) {
		BoardVO detail = repository.detail(bno);
		return detail.getBno();
		
	}
}
