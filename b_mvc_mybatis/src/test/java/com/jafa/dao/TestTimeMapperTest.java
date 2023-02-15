package com.jafa.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:spring-config/root-context.xml",
		"classpath:spring-config/servlet-context.xml",
		
})
@WebAppConfiguration
public class TestTimeMapperTest {
	@Autowired
	TestTimeMapper test;
	
	@Test
	public void test() {
		System.out.println(test.getTime());
	}

}
