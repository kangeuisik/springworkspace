package com.jafa.repository;

import java.util.Date;
import java.util.List;

import com.jafa.domain.ToDoDTO;
import com.jafa.domain.ToDoVO;

public interface ToDoRepository {

	List<ToDoVO> selectAllByMonth(String date); //한달한달 단위로
	//파라미터가 두개 이상이면 @Param("?") 붙여주어야 함
					
	void save(ToDoDTO dto);
}
