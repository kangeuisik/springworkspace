package com.jafa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Criteria {
	
	private int pageNum; //현재 페이지
	private int amount= 10; // 페이징 게시물수(10)
	
	public Criteria() {
		this(1,10);
	}
}
