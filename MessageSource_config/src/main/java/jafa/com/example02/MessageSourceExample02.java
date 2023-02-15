package jafa.com.example02;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.AppConfig2;

public class MessageSourceExample02 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				 new AnnotationConfigApplicationContext(AppConfig2.class);
	

		String message = ctx.getMessage("myword.hello", null, Locale.getDefault());
		String message_en = ctx.getMessage("myword.hello", null, Locale.ENGLISH);
		String welcome = ctx.getMessage("welcome",new String[] {"홍길동","우리집"}, Locale.getDefault());
		
		System.out.println(message);
		System.out.println(message_en);	
		System.out.println(welcome);
		
	}
}
