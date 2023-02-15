package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jafa") // 어디에서 스프링빈을 찾을래? 패키지 이름
public class AppContext {
	
	//basePckages  = "com" 이하 검색
	//com 패키지 검색
	//com.jafa 패키지 검색
	//com.jafa.spring 패키지 검색

	//basePackages = "com.jafa" // com.jafa이하 패키지 검색
	//com.jafa 패키지검색
	//com.jafa.spring 패키지검색
}
