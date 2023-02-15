package jafa.com.example01;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceExample01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appConfig01.xml");
	
		// greeting_ko_KR.properties -> greeting.properties
		String message = ctx.getMessage("myword.hello", null, Locale.getDefault());
		System.out.println(message);

		// greeting_en.properties -> greeting.properties
		String message_en = ctx.getMessage("myword.hello", null, Locale.ENGLISH);
		System.out.println(message_en);

	
		String welcome = ctx.getMessage("welcome",new String[] {"홍길동","우리집"}, null);
		System.out.println(welcome);
		
	}
}
