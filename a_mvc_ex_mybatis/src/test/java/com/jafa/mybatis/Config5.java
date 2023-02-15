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


import com.jafa.config.mybatis.MybatisConfing5;
import com.jafa.dao.BoardDao;
import com.jafa.dao.BookRepository;
import com.jafa.domain.BoardVO;
import com.jafa.domain.BookVO;
import com.jafa.domain.MemberVO;
import com.jafa.mapper.BoardRepository;
import com.jafa.mapper.MemberMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,ServletConfig.class,MybatisConfing5.class})
@WebAppConfiguration
public class Config5 {
	
	@Autowired
	MemberMapper memberRepository;

	@Test
	public void test() {
		MemberVO vo = memberRepository.findByMno(1L);
		System.out.println(vo);
	}
	
	
}
