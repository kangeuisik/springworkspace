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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("boardVO") // 이름을 안쓰면 첫글자로 바뀐 boardVO로 기본값으로 설정됨
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
}
