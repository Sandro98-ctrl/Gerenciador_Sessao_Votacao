package br.com.compasso.gerenciador.validation.annotation;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateTimeValidator implements ConstraintValidator<DateTime, String>{

	private String pattern;
	
	@Override
	public void initialize(DateTime constraintAnnotation) {
		pattern = constraintAnnotation.pattern();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			LocalDateTime.parse(pattern);
		}
		catch (Exception e) {
			
			return false;
		}

		
		
		return true;
	}
}
