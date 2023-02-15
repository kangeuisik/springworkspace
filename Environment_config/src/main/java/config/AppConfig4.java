package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jafa.example03.JdbcConnector;




@Configuration
@PropertySource(value = {
		"classpath:example03/oracle.properties"
})
public class AppConfig4 {
	@Value("${db.driver}")
	String driver;
	@Value("${db.url}")
	String url;
	@Value("${db.username}")
	String username;
	@Value("${db.password}")
	String password;
	@Bean
	public JdbcConnector jdbcConnector() {
		JdbcConnector jdbcConnector = new JdbcConnector();
		jdbcConnector.setDriver(driver);
		jdbcConnector.setUrl(url);
		jdbcConnector.setUsername(username);
		jdbcConnector.setPassword(password);
		return jdbcConnector;
	}
}
