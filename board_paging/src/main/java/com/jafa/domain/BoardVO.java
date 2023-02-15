package com.jafa.domain;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	
}
