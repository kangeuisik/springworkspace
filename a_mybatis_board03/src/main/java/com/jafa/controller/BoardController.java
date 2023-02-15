package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;
import com.jafa.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	BoardRepository repository;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(String type, String keyword,Model model) {
		model.addAttribute("list", repository.findAll(type,keyword));
		return "board/list";
	}

	@RequestMapping(value = "/list2",method=RequestMethod.GET)
	public String list(
			@ModelAttribute("cri") Criteria criteria,Model model) {
		model.addAttribute("list", repository.findAll2(criteria));
		return "board/list";
	}

}
