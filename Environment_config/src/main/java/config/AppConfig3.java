package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jafa.example03.JdbcConnector;

@Configuration
@PropertySource(value = {
		"classpath:example03/mysql.properties",
		"classpath:example03/oracle.properties"
})
public class AppConfig3 {
	@Autowired
	Environment env;
	@Bean
	public JdbcConnector jdbcConnector() {
		JdbcConnector jdbcConnector = new JdbcConnector();
		jdbcConnector.setDriver(env.getProperty("db.driver"));
		jdbcConnector.setUrl(env.getProperty("db.url"));
		jdbcConnector.setUsername(env.getProperty("db.username"));
		jdbcConnector.setPassword(env.getProperty("db.password"));
		return jdbcConnector;
	}
}
