package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import jafa.com.example03.LoginResult;

@Configuration

public class AppConfig4 {
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource =
				new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(
				"classpath:message04/welcom",
				"file:src/main/webapp/message04/greeting"
				);
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}
	

}
