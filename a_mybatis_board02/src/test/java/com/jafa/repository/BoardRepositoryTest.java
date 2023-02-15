package com.jafa.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.BoardVO;

public class BoardRepositoryTest extends AppTest{
	@Autowired
	BoardRepository repository;
	
	@Test
	@Ignore
	public void test() {
		List<BoardVO> list = repository.list();
		System.out.println(list);
	}
	@Test
	@Ignore
	public void test2() {
		BoardVO list = repository.detail(1L);
		System.out.println(list);
	}
	
	@Test
	@Ignore
	public void test3() {
		List<BoardVO> list2 = repository.list2();
		System.out.println(list2);
	}
	@Test
	@Ignore
	public void test4() {
		repository.detail2(1L);
		
	}
	@Test
	public void test5() {
		BoardVO vo = BoardVO.builder()
				.title("제목추가").content("내용추가").writer("관리자")
				.build();
		repository.save(vo);
		System.out.println("bno : "+vo.getBno());
		
	}
	
}
