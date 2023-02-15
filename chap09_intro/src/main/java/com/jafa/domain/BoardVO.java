package com.jafa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	
	private String title; 
	private String writer;
	private String content;
	
	public BoardVO(String title, String writer) {
		this.title = title;
		this.writer = writer;
	}
	
}
