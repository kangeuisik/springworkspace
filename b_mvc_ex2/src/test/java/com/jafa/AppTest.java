package com.jafa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring-config/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring-config/servlet-context.xml"
})
@WebAppConfiguration
public class AppTest {

	@Test
	public void test() {
		String test = "test";
		assertEquals("test", test);
	
		MatcherAssert.assertThat(test, is("test"));
		MatcherAssert.assertThat(test, containsString("tes")); //이러한 문자열이 포함되있는가
	}

}
