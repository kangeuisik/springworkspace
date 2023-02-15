package com.jafa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Criteria {

	private int page; // 현재페이지
	private int perPageNum; // 한페이지에 표시할 게시물 수
	
	private String keyword;
	private String type;
	
	public Criteria() {
		this(1, 10); // 변수 값 할당 
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	//#{minRow}
	public int getMinRow() {
		return (this.page-1)*this.perPageNum;
	}
	//#{maxRow}
	public int getMaxRow() {
		return this.page*this.perPageNum;
	}

}
