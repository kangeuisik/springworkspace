package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.AttachVO;
import com.jafa.domain.BoardVO;
import com.jafa.service.AttachService;
import com.jafa.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	

	@Autowired
	BoardService Bservice;
	@Autowired
	AttachService Aservice; 
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",Bservice.list());
		return "board/list";
	}
	@GetMapping("/write")
	public String writeForm() {
		return "board/write";
	}
	@PostMapping("/write")
	public String write(BoardVO vo, RedirectAttributes rttr,
			@RequestParam("attachFile") MultipartFile[] multipartFiles) {
		
		Bservice.write(vo, multipartFiles);
		return "redirect:/board/list";
	}
	@GetMapping("/detail")
	public void detail(Long bno,Model model) {
		BoardVO vo = Bservice.detail(bno);
		model.addAttribute("b",vo);
		if(vo.getAttachFileCnt()>0) {//첨부파일이 있을때
			//첨부파일 리스트를 가져옴
			List<AttachVO> attachList = Aservice.list(bno);
			model.addAttribute("attachList",attachList);
		}
	}
	@PostMapping("/remove")
	public String remove(Long bno) {
		Bservice.remove(bno);
		return "redirect:/board/list";
	}
	//수정폼
	@GetMapping("/modify")
	public void modify(Long bno,Model model) {
		BoardVO vo = Bservice.detail(bno);
		model.addAttribute("b",vo);
		if(vo.getAttachFileCnt()>0) {//첨부파일이 있을때
			//첨부파일 리스트를 가져옴
			List<AttachVO> attachList = Aservice.list(bno);
			model.addAttribute("attachList",attachList);
		}
	}
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr,
			@RequestParam(value = "delFileList") List<Long> delFileList,
			@RequestParam(value = "attachFile") MultipartFile[] multipartFiles){
		Bservice.modify(vo,delFileList,multipartFiles);
		log.info(vo);
		log.info("삭제리스트"+delFileList);
		return "redirect:/board/list";
	}
	
}
