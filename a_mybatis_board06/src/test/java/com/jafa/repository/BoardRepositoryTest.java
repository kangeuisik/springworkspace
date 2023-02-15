package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.Criteria;

public class BoardRepositoryTest extends AppTest{
	@Autowired
	BoardRepository repository;
	
	@Test
	@Ignore
	public void test() {
		Criteria criteria = new Criteria(3,10);
		repository.list(criteria);
	}
	@Test
	public void test2() {		
		Criteria criteria = new Criteria();
		criteria.setKeyword("파이썬");
		criteria.setType("T");
		repository.getTotalCount(criteria);
	}
	@Test
	public void test3() {		
		Criteria criteria = new Criteria();
		criteria.setType("W");
		criteria.setKeyword("운영자");
		repository.list(criteria);
	}
}
