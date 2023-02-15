package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.dao.BoardDao;
import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;
import com.jafa.domain.PageNation;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/list")
	public String list(Criteria criteria, Model model) {
		
		List<BoardVO> list = dao.list(criteria);
		PageNation pageNation  = new PageNation(criteria, dao.totalCount());
		model.addAttribute("list",list);
		model.addAttribute("p",pageNation);
		
		return "/board/list";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam("bnumber") Long bno, Model model) {
		//형변환 필요없음 스프링이 함
		try {
			BoardVO detail = dao.detail(bno);
			model.addAttribute("board",detail);
			
		} catch (Exception e) {
			return "/error/notFoundArticle";
		}
		
		return "/board/detail";
		
	}

}
