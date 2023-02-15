## 프로젝트 준비
	- a_mvc_ex 복사
	  a_mvc_mybatis_config 생성

## mybatis
	- mybatis
	  mybatis-spring 2.xxx
	  
	  
## 마이바티스 설정
	- 설정 파일 : com.jafa.config.RootConfig
	- @MapperScan("com.jafa.repository") 매퍼인터페이스 패키지 설정
	- SqlSessionFactoryBean 등록
		- DataSource 빈 전달 
		- mapperLocations :  new PathMatchingResourcePatternResolver() classpath:mappers/**/*Mapper.xml
	- SqlsessionTemplate
		- SqlSessionFactory : SqlSessionFactoryBean.getObject()부터 얻음
		- SqlSessionFactoryBean 생성자 주입
		
## 매퍼 인터페이스 및 매퍼 xml 작성
	- 매퍼인터페이스 : com.jafa.repository.TestRepository
	- 매퍼 파일 : classpath:mappers/TestMapper.xml
	- 테스트케이스 : com.jafa.repository.TestRepositoryTest
	
## log4j 설정
	- 모듈 추가
		- log4j 2번째거
		  slf4j-log4j12
		  jcl-over-slf4j
		  spring-core : exclude(commons-logging)
		  	 <exclusions>
			    	<exclusion>
			    		<groupId>commons-logging</groupId>
			    		<artifactId>commons-logging</artifactId>
			    	</exclusion>
			   </exclusions>
	- 로그 설정 파일 : classpath:log4j.xml
	
## log4jbc-log4j2 설정
	- 모듈추가
		Log4Jdbc Log4j2 JDBC 4 1	
	- RootConfig 에서 DataSource 재설정
	- log4jdbc-log4jdbc.log4j2.properties
	- log4j.xml 로그레벨 조정
