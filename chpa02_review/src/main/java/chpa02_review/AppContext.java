package chpa02_review;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chpa02_review.Greeter;
@Configuration
public class AppContext {
		@Bean
		public MemberDao memberDao() {
			return new MemberDao();
		}
		
		//스프링컨테이너가 객체를 생성
		@Bean
		public ConnectionUtil connectionUtil() {
			ConnectionUtil util = new ConnectionUtil();
			//Setter Injection
			util.setDriver("com.oracle.com");
			util.setUrl("localhost:8080");
			util.setUsername("scott");
			util.setPassword("tiger");
			return util;
		}
}
