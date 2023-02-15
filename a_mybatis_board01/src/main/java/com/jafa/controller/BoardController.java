package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.BoardVO;
import com.jafa.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	BoardRepository repository;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", repository.findAll());
		return "board/list";
	}
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("bno") Long bno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/detail"); //뷰이름
		mav.addObject("board",repository.detail(bno)); //뷰에서 사용할 데이터
		return mav;
	}
	//수정폼
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		model.addAttribute("board",repository.detail(bno));
		return "board/modify";
	}
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		repository.update(vo);
		rttr.addFlashAttribute("result",vo.getBno()+"수정함");
		return "redirect:/";
	}
	@PostMapping("/delete")
	public String delete(Long bno, RedirectAttributes rttr) {
		repository.delete(bno);
		rttr.addFlashAttribute("result", bno+"삭제함");
		return "redirect:/";
	}
	
	//post, get 이 다르다면 매핑을 같이 해도 됨
}
