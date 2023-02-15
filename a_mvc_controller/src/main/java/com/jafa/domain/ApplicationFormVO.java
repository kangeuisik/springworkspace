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
public class ApplicationFormVO {
	private String name;
	private String email;
	
	private List<University> universityList;
	//University 대학이름, 전공 정의
	// 1지망, 계명대 수학
	// 2지망, 영남대 전기
	// 3지망, 대구개 기계
}
