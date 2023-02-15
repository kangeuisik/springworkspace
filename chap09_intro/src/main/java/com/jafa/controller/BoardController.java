package com.jafa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.dao.BoardDao;
import com.jafa.domain.BoardVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	private BoardDao boardDao;

	@GetMapping("/board/list")
	public void boardList(Model model) {
		List<BoardVO> list = boardDao.selectAll();
		model.addAttribute("list",list);
	}
	
	@GetMapping("/board/detail")
	public void detail(@RequestParam(defaultValue = "0") int bno) {
		System.out.println("게시물 상세");
		System.out.println(bno);
	}
	
	
	@RequestMapping("/board/write")
	public String writeFrom() {
		return "/board/write";
	}
	
	@RequestMapping(value = "/board/write", method=RequestMethod.POST)
	public String wrtie(BoardVO board){
		System.out.println(board);
		return "redirect:/";
	}
	
}
