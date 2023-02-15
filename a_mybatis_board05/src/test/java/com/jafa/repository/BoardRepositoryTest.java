package com.jafa.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardRepositoryTest extends AppTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	@Ignore
	public void testTotalCount() {
		int totalCount = repository.getTotalCount();
		log.info(totalCount);
	}
	
	@Test
	@Ignore
	public void testList() {
		List<BoardVO> list = repository.list(new Criteria(2,10));
	}
	
	@Test
	public void testDetail() {
		repository.detail(1L);
	}
	
	
}
