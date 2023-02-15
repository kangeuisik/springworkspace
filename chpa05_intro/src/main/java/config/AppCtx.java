package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.spring.BoardDao;
@Configuration
@ComponentScan(basePackageClasses = BoardDao.class)
public class AppCtx {
	
	//kr.co.spring
	//kr.co.BoardDao
	//(basePackageClasses = BoardDao.class)
	//kr.co 패키지 검색
	//kr.co.의 하위 패키지인 spring도 검색

	
}
