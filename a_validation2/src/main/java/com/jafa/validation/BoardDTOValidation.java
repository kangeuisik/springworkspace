package com.jafa.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jafa.domain.BoardDTO;

public class BoardDTOValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardDTO dto = (BoardDTO) target;
		
		//제목
		if(dto.getTitle()==null || dto.getTitle().isBlank()) {
			errors.rejectValue("title", "notExpect.title");
		}else {
			String title = dto.getTitle();
			if(title.length()==0 || title.length()>20) {
				errors.rejectValue("title", "limit.title");
			}
		}
		//내용
		//작성자
	}

}
