package chpa02_review;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MemberDao {
	@Bean
	public Greeter greeting() {
		Greeter g = new Greeter(); 
		g.setFormat("%s님 안녕하세요");
		return g;
	}

	public void greeting(String string) {
		// TODO Auto-generated method stub
		
	}
}
