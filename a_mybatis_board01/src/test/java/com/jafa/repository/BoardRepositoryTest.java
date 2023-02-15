package com.jafa.repository;

import static org.junit.Assert.*;

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
	public void findAlltest() {
		repository.findAll();
	}
	@Test
	@Ignore
	public void detailTest() {
		repository.detail(1L);
	}
	@Test
	@Ignore
	public void saveTest() {
		repository.save(BoardVO.builder()
				.title("제목이야").content("내용이야").writer("관리자")
				.build());
	}
	@Test
	public void updateTest() {
		repository.update(BoardVO.builder()
				.title("제목수정").content("내용수정").bno(5L)
				.build());
	}
}
