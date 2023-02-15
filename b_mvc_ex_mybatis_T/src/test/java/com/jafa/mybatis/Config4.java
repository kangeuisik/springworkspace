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

import com.jafa.dao.BoardDao;
import com.jafa.dao.BookRepository;
import com.jafa.dao.MemberDao;
import com.jafa.domain.BoardVO;
import com.jafa.domain.BookVO;
import com.jafa.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring-config/root-context.xml",
	"classpath:spring-config/servlet-context.xml",
	"classpath:spring-config/mybatis/mybatis-config4.xml",
})
@WebAppConfiguration
public class Config4 {
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	BookRepository bookRepository;

	@Test
	public void test() {
		System.out.println(boardDao.findByWriter("관리자"));
	}
	
	@Test
	public void test2() {
		BookVO vo = BookVO.builder()
					.title("스프링5.0")
					.writer("최범균").build();
		bookRepository.addBook(vo);
		System.out.println(vo.getId());
	}

}
