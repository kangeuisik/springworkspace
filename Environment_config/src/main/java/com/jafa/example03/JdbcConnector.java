package com.jafa.example03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JdbcConnector {
	
	String driver;
	String url;
	String username;
	String password;
	
	
}
