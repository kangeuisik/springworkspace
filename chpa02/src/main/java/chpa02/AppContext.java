package chpa02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 컨테이너가 참조하는 설정정보 클래스
public class AppContext {
	//스프링 컨테이너가 관리하는 객체를 스프링빈이라고함...
	
	//스프링빈 설정
	@Bean// 스프링빈으로 관리될 객체를 반환함
	//@bean의 name속성을 지정하지 않으면 빈의 이름은 메서드 이름과 같다.
	public Greeter greeting() {
		Greeter g = new Greeter(); 
		g.setFormat("%s님 안녕하세요");
		return g;
	}
}
