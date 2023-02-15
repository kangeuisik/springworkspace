package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberService;

@Configuration
public class AppContext {
	

//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}

	@Bean(name = "memberSvc")
	public MemberService memberService() {
		MemberService service = new MemberService();
		return service;
	}

}
