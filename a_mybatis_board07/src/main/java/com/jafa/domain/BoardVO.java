package com.jafa.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Alias("board")
public class BoardVO {
	
	private Long bno;
	private String category;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
}
