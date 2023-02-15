package com.jafa.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.dao.BoardDao;
import com.jafa.dao.MemberDao;
import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring-config/root-context.xml",
	"classpath:spring-config/servlet-context.xml",
	"classpath:spring-config/mybatis/mybatis-config2.xml",
})
@WebAppConfiguration
public class Config2 {
	
	@Autowired
	MemberDao memberDao; 
	
	@Autowired
	BoardDao boardDao;

	@Test
	public void test() {
		MemberVO vo = memberDao.findByMno(1L);
		System.out.println(vo);
	}
	
	@Test
	public void test2() {
		List<BoardVO> list = boardDao.findByWriter("관리자");
		System.out.println(list);
	}

}
