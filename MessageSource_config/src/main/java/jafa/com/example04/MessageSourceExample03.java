package jafa.com.example04;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig3;
import config.AppConfig4;

public class MessageSourceExample03 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig4.class);

		String message = ctx.getMessage("myword.hello", null,Locale.getDefault());
		String message2 = ctx.getMessage("welcome", new String[] {"김민재","우리집"}, Locale.getDefault());
		System.out.println(message);
		System.out.println(message2);
	}
}
