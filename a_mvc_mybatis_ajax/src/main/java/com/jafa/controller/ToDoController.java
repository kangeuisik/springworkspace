package com.jafa.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.DateVO;
import com.jafa.domain.ToDoDTO;
import com.jafa.domain.ToDoVO;
import com.jafa.repository.ToDoRepository;
import com.jafa.util.CalendarUtil;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	ToDoRepository toDoRepository;
	
	
	//이미 날짜가 생성이 되고 
	//후속작업으로 일정등록을 하는것임
	@GetMapping("/{year}/{month}")
	public String dayList(Model model,@PathVariable Integer month,
			@PathVariable Integer year) {
		//포매팅 이용 문자열로 
		//필요한건 20230301 = 현재 20233
		//특정형식을 만들어주기 위해 포매팅 사용
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		//월별 해야할일
		List<ToDoVO> todoList = toDoRepository.selectAllByMonth(sdf.format(cal.getTime()));
		
		//월별 날짜 구현
		//날짜를 기준으로 일정 넣어줘야함
		//포매팅날짜와 월날짜가 같을때 일정이 나오게끔 구현 ,반복문 조건문이용
		List<DateVO> dateList = CalendarUtil.getDate(year, month-1);
		for(ToDoVO toDo : todoList) {
			//포매팅형식을 넣어줌
			//db에서 할일을 기록한 날짜
			String todoDate = sdf.format(toDo.getToDoDate());
			for(DateVO vo : dateList) {
				// vo=3월 전체 날짜
				if(todoDate.equals(vo.toString())) {
				vo.setToDoList(toDo);
				//vo.getToDoList().add(toDo);
				//오류 왜? DateVO에서 List<todo>를 만든적 없어서
				//settodolist를 새로 정의해줘야함
				}
			}
		}
		model.addAttribute("dateList",dateList);
		return "cal/dayList";
	}
	@PostMapping("/toDoWrite")
	public String toDoWrite(ToDoDTO dto) {
		//리스트라 래퍼클래스 씌워서 보내줘야함
		toDoRepository.save(dto);
		String year = dto.getToDoDate().substring(0, 4);
		String month = dto.getToDoDate().substring(4, 6);
		
		return "redirect:/todo/"+year+"/"+month;
	}
	
}
