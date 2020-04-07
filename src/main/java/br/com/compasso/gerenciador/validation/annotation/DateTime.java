package br.com.compasso.gerenciador.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {

	String message() default "Data e hora em formato inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
    String pattern();
}
