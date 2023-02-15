package config.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberPrinter;
@Configuration
@Import(value = {AppConfig2.class})
//하나의 메인설정을 두고 밸류값으로 불러올수 있으면 배열로도 불러올수 있다.
public class AppConfig {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
