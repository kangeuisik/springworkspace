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
public class MemberVO {
	private Long mno;
	private String memberId;
	private String memberName;
	private String password;
	private String email;
	private String phoneNumber;
}
