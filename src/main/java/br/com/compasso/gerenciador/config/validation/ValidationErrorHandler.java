package br.com.compasso.gerenciador.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {

	private MessageSource messageSource;
	
	public ValidationErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDTO> handle(MethodArgumentNotValidException ex){
		var errors = new ArrayList<FormErrorDTO>();
		
		ex.getBindingResult().getFieldErrors().forEach(e -> {
			var message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			errors.add(new FormErrorDTO(e.getField(), message));
		});
		
		return errors;
	}
	
}
