package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jafa.dao.SampleDao;
import com.jafa.domain.SampleVO;

// @RequestMapping, PostMapping, GetMapping, 커맨드객체
@Controller
@RequestMapping("/sample03") // 클래스 단위에 @RequestMapping 적용
// 메서드에 지정한 경로와 결합하여 동작
public class SampleController02 {
	@Autowired
	SampleDao sampleDao;
	
	// get 방식 method 속성 생략가능
	// value 속성을 단독으로 사용할시 속성명 생략가능
	@RequestMapping(value = "/list1",method = RequestMethod.GET)
	public String list1() {
		return "sample01/sampleList01";
	}
	// 배열을 사용하면 여러경로를 지정할 수 있음
	@RequestMapping(value = {"/list2", "/list"})
	public String list2() {
		return "sample02/sampleList02";
	}
	@GetMapping("/sampleForm")
	// @RequestMapping(value = "/list1",method = RequestMethod.GET)과 같음...
	public String sampleForm() {
		return "sample02/sampleForm";
	}
	//@PostMapping("/sampleProceed")
	@RequestMapping(value = "/sampleProceed", method = RequestMethod.POST)
	public String list4(@ModelAttribute("svo") SampleVO vo) {
		//컨트롤러 메소드에 사용된 참조타입 파라미터를 커맨드 객체라 함
		//커맨드 객체는 모델에 데이터를 등록하지 않고 뷰에서 사용할 수 있다
		// 이 때 뷰페이지에서 사용할 이름은 sampleVO이다 (타입
		//뷰에서 사용할 이름을 변경하려면 @ModelAttribute 사용
		// 커맨드 개체를 사용하려면 기본생성자가 반드시 있어야함
		System.out.println(vo);
		return "sample02/sampleResult";
	}

}
