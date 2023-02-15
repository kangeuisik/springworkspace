package com.jafa.validation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;



public class FieldMatchValidate implements ConstraintValidator<FieldMatch, Object>{

	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		this.firstFieldName = constraintAnnotation.first();
		this.secondFieldName = constraintAnnotation.second();
		this.message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			String first = BeanUtils.getProperty(value, firstFieldName);
			String second = BeanUtils.getProperty(value, secondFieldName);
			valid = first!=null && second!=null && first.equals(second);
			if(!valid) {
				context.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName)
				.addConstraintViolation().disableDefaultConstraintViolation();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	
}
