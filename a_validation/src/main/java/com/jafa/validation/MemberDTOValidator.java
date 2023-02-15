package com.jafa.validation;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jafa.domain.MemberDTO;

public class MemberDTOValidator implements Validator{

	//검증대상의 객체 타입 정의 
	@Override
	public boolean supports(Class<?> clazz) {

		return MemberDTO.class.isAssignableFrom(clazz);
	}
	
	//검증 작업 수행 메서드
	@Override
	public void validate(Object target, Errors errors) {
		MemberDTO dto = (MemberDTO) target;
		//이름
		if(dto.getMemberName()==null || dto.getMemberName().isBlank()) {//이름을 입력하지 않았을때
			errors.rejectValue("memberName", "required.name");
		}else {//값이 있는 경우
			String memberName = dto.getMemberName();
			if(memberName.length()<2 || memberName.length()>6) {//이름은 2-6글자 
				errors.rejectValue("memberName", "length.name");
			}else if(!Pattern.matches("^[가-힣|a-z|A-Z]*$", memberName)) {//한글 또는 영문 허용 정규식
				errors.rejectValue("memberName", "nameChar.name");
			}
		}
		
		//아이디
		if(dto.getMemberId()==null || dto.getMemberId().isBlank()) {//이름을 입력하지 않았을때
			errors.rejectValue("memberId", "required.memberId");
			//4-6자 영문 숫자 허용
		}else {
			String memberId = dto.getMemberId();
			if(memberId.length()<5 || memberId.length()>14) {
				errors.rejectValue("memberId", "length.memberId");
			}else if(!Pattern.matches("^[a-z|A-Z|0-9]*$", memberId)) {
				errors.rejectValue("memberId", "idChar.memberId");
			}
		}
		
		//비밀번호
		if(dto.getPassword()==null || dto.getPassword().isBlank()) {//이름을 입력하지 않았을때
			errors.rejectValue("password", "required.password");
		}else {
			String password = dto.getPassword();
			if(!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}", password)) {//널검사
				errors.rejectValue("password", "limit.password");
			}else if(!password.equals(dto.getConfirmPassword())) {//비밀번호 일치여부
				errors.rejectValue("password", "notMaching.password");
				errors.rejectValue("confirmPassword", "notMaching.password");
			}
		}
		//이메일
		if(dto.getEmail()==null || dto.getEmail().isBlank()) {//이름을 입력하지 않았을때
			errors.rejectValue("email", "required.email");
		}else {
			String email = dto.getEmail();
			if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", email)) {
				errors.rejectValue("email", "notExpect.email");
			}
		}
			
		//번호
		if(dto.getPhoneNumber()==null || dto.getPhoneNumber().isBlank()) {//이름을 입력하지 않았을때
			errors.rejectValue("phoneNumber", "required.phoneNumber");
		}else {
			String phoneNumber = dto.getPhoneNumber();
			if(!Pattern.matches("^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", phoneNumber)) {
				errors.rejectValue("phoneNumber", "notExpect.phoneNumber");
			}
		}
	}
}
