package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration

public class AppConfig2 {
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource =
				new ResourceBundleMessageSource();
		messageSource.setBasenames("message02.greeting","message02.welcome");
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}
}
