package com.jafa.domain;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BoardVO {
	private int bno;
	private String cid; // 외래키
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	
	private Category category;

}
