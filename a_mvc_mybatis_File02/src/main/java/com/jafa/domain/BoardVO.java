package com.jafa.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Integer attachFileCnt; //첨부파일 개수
	
	//게시물 : 첨부파일 = 1:n
	

}
