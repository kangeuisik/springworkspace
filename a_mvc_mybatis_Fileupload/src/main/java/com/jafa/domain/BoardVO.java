package com.jafa.domain;


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
	private String fileName;
	private FileType fileType;

public enum FileType{
	IMAGE, OTHER;
}
}
