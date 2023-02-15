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
public class MemberDTO {
	private String memberId;
	private String memberName;
	private String password;
	private String confirmPassword; //일치여부 암호확인.
	private String email;
	private String phoneNumber;
}
