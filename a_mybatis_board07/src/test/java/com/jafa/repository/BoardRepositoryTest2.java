package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.Criteria;

public class BoardRepositoryTest2 extends AppTest {
	@Autowired
	BoardRepository repository;
	
	
	//검색어 : x , 카테고리 x
	@Test
	public void test() {
		Criteria criteria = new Criteria();
		repository.list(criteria);
	}
	//검색어 : o , 카테고리 x
	@Test
	public void test2() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("스프링");
		repository.list(criteria);
	}
	//검색어 : o , 카테고리 o
	@Test
	public void test3() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("스프링");
		criteria.setCategory("notice");
		repository.list(criteria);
		}
	//검색어 : x , 카테고리 o
	@Test
	public void test4() {
		Criteria criteria = new Criteria();
		criteria.setCategory("notice");
		repository.list(criteria);
		}
}
