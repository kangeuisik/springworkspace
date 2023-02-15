package com.jafa.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;

import com.jafa.config.mybatis.MybatisConfing3;
import com.jafa.dao.BoardDao;
import com.jafa.dao.BookRepository;
import com.jafa.domain.BoardVO;
import com.jafa.domain.BookVO;
import com.jafa.mapper.BoardRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,ServletConfig.class,MybatisConfing3.class})
@WebAppConfiguration
public class Config4 {
	@Autowired
	BoardRepository boardRepository;
	
	

	@Test
	public void test() {
		BoardVO vo = boardRepository.findByBno(1L);
		System.out.println(vo);
	}
	
	
}
