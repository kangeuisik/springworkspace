package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jafa.dao.SampleDao;

@Controller
public class SampleController {
	@Autowired
	SampleDao sampleDao;
	
	
	@RequestMapping("/sample01/list")
	public String list1() {
		//반환 타입 String : view 이름
		//@RequestMapping : method속성을 설정하지 않으면 get 방식전송
		return "sampleList";
	}
	@RequestMapping("/sample01/list2")
	public String list2(Model model) {
		// @param1 : 뷰에서 사용할 모델 이름
		// @param2 : 모델객체에 저장할 데이터
		model.addAttribute("list",sampleDao.list());
		return "sample01/sampleList2";
	}
	@RequestMapping("/sample01/list3")
	public String list3(Model model) {
		// Model의 반환값은 자기자신이므로 메서드 체인방식으로 작성가능
		model.addAttribute("list",sampleDao.list()).addAttribute("userName","홍길동");
		return "sample01/sampleList3";
	}
	@RequestMapping("/sample01/list4")
	public String list4(ModelMap modelmap) {
		// Model의 반환값은 자기자신이므로 메서드 체인방식으로 작성가능
		modelmap.addAttribute("list",sampleDao.list()).addAttribute("userName","홍길동");
		return "sample01/sampleList4";
	}
	@RequestMapping("/sample01/list5")
	public String list5() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sample01/sampleList5");
		mav.addObject("list",sampleDao.list());
		return "sample01/sampleList5";
	}
}
