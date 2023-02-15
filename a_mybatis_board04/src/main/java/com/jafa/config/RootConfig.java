package com.jafa.config;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Category;

@Configuration
@MapperScan("com.jafa.repository")
public class RootConfig {
	
	
	
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("springdb");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		 factory.setDataSource(dataSource());
		 factory.setMapperLocations(
				 new PathMatchingResourcePatternResolver()
				 .getResources("classpath:mappers/**/*Mapper.xml"));
		 factory.setTypeAliases(BoardVO.class,Category.class);
		return factory;
	}
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory().getObject());
	}
}
