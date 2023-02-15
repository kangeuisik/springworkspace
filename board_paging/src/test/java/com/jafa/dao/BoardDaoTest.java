package com.jafa.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.jafa.AppTest;
import com.jafa.domain.Criteria;

public class BoardDaoTest extends AppTest{
	@Autowired
	BoardDao boardDao;
	@Test
	@Ignore
	public void testList() {
		Criteria criteria = new Criteria(2,20);
		int size = boardDao.list(criteria).size();
		assertEquals(20, size);
		System.out.println(boardDao.list(criteria));
	}
	@Test
	@Ignore
	public void countTest() {
		int totalCount = boardDao.totalCount();
		assertEquals(413, totalCount);
	}
	
	@Test
	public void detailTest() {
		assertNotNull(boardDao.detail(3L));
		System.out.println(boardDao.detail(3L));
	}
	//예외가 날 것을 예상하고..
	@Test(expected = EmptyResultDataAccessException.class)
	public void detailTes2() {
		assertNotNull(boardDao.detail(1000L));
		
	}
}
