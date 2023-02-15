package com.jafa.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;
import com.jafa.config.mybatis.MybatisConfing2;
import com.jafa.dao.BoardDao;
import com.jafa.domain.BoardVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,ServletConfig.class,MybatisConfing2.class})
@WebAppConfiguration
public class Config2 {
	
	
	@Autowired
	BoardDao dao;
	

	@Test
	@Ignore
	public void test() {
		List<BoardVO> list = dao.findByWriter("관리자");
		System.out.println(list);
	}
	
	
}
