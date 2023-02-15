package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import com.jafa.example05.JdbcConnector05;




@Configuration
@PropertySource(value = {
		"classpath:example5/oracle.properties"
})
public class AppConfig5 {
	@Bean
	public JdbcConnector05 jdbcConnector05() {
		return new JdbcConnector05();
	}
	
}
