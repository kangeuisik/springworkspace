package com.jafa.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.jafa.validation.FieldMatch;

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
@FieldMatch(first = "password", second = "confirmPassword",message = "암호확인이 일치하지 않음")
public class MemberDTO {
	@NotBlank(message = "아이디는 필수 항목입니다")
	@Length(min=4, max=16, message = "아이디는 4-6자 사이여야 합니다.")
	private String memberId;
	
	private String memberName;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&]{8,}")
	private String password;
	
	private String confirmPassword; //일치여부 암호확인.
	
	@Email(message = "이메일 안맞다 똑바로 적자")
	@NotBlank(message = "적어라 좀..")
	private String email;
	
	private String phoneNumber;
}
