package com.jafa.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/sample04")
public class SampleController04 {
	
	
	//httpservletRequest 사용
	//요청 : /sample04/list1?id=lee
	//뷰에서 데이터를 사용하려면 request 객체보관소에 저장해야함 
	@GetMapping("/list1")
	public String list1(HttpServletRequest request) {
		String userId = request.getParameter("id");
		request.setAttribute("userId", userId);
		return "sample04/sampleList1";
		
	}
	//@Requestparam 사용
	//요청 : /sample04/list2?userId=lee
	//뷰에서 데이터를 사용하려면 model객체보관소에 저장해야함
	@GetMapping("/list2")
	public String list2(@RequestParam("userId") String Id,Model model) {
		System.out.println(Id);
		model.addAttribute("userId",Id);
		return "sample04/sampleList2";
	}
	//쿼리스트링의 ket 값과 @RequestParam 이 붙은 파라미터 이름이 같은 경우 @RequestParam을 생략할 수 있다.
	//요청 : /sample04/list3?id=lee
	@GetMapping("/list3")
	public String list3(String id,Model model) {
		System.out.println(id);
		model.addAttribute("userId",id);
		return "sample04/sampleList3";
	}
	//required 기본값 : false
	//required 속성값이 true 일때 파라미터를 전달하지 않으면 400에러 발생
	//요청 : /sample04/list4?id=lee
	@GetMapping("/list4")
	public String list4(@RequestParam(required = true) String name) {
		System.out.println(name);
		return "sample04/sampleList4";
	}
	//기본타입(primitive type)은 null값이 될수 없으므로 illegalStateException예외 발생
	//기본타입에 상응하는 래퍼객체를 사용할것을 권장
	//long > Long / int > Integer
	//요청 : /sample04/list5
	@GetMapping("/list5")
	public String list5(long mno) {
		
		return "sample04/sampleList5";
	}
	//파라미터를 전달하지 않았을 경우 defaultValue 속성을 사용하여 기본값을 지정할 수 있음
	//요청 : /sample04/list6
	@GetMapping("/list6")
	public String list6(@RequestParam(defaultValue = "10") long mno) {
		System.out.println(mno);
		return "sample04/sampleList6";
	}
	//동일한 이름의 key값으로 여러개를 받을 경우 배열,컬렉션을 사용한다.
	//요청 : /sample04/list7?name=lee & name=kim & name=kang
	@GetMapping("/list7")
	public String list7(@RequestParam("name") String[] names) {
		System.out.println(Arrays.toString(names));
		return "sample04/sampleList7";
	}
	
	
	@GetMapping("/list8")
	public String list8(@RequestParam("address") List<String> address) {
		System.out.println(address);
		return "sample04/sampleList8";
	}
	@GetMapping("/sampleForm2")
	public String sampleForm1() {
		return "sample04/sampleForm2";
	}
	//@RequestParam 생략할수 없다.
	//요청 파라미터의 key, value 가 Map의 key, value에 대응된다
	@GetMapping("/list9")
	public String list9(@RequestParam Map<String, String> map) {
		System.out.println(map);
		return "sample04/sampleList9";
	}
}
