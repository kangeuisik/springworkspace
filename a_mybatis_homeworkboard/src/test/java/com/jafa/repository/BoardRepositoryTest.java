package com.jafa.repository;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardRepositoryTest extends AppTest{
	
	@Autowired
	BoardRepository repository;
	
	@Test
	public void test() {
		log.info(repository.list("free"));
	}

}
