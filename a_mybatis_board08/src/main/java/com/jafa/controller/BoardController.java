package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	BoardRepository repository;

	@GetMapping("/list")
	public String boardList(Model model) {
		model.addAttribute("boardList",repository.boardList());
		return "board/list";
	}
	@PostMapping("/delSelectedBoard")
	public String delSelBoard(String bnoList) {
		log.info(bnoList);
		String[] bnoArray = bnoList.split(",");
		repository.delAllSelected(bnoArray);
		return "redirect:/board/list"; // 삭제하고 원래 페이지
	}
}
