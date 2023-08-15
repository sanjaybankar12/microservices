package com.spring.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.exception.DepartmentNotFoundException;
import com.spring.exception.ErrorMessage;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleDepartmentNotFoundException(DepartmentNotFoundException ex) {
		ErrorMessage em = new ErrorMessage();
		em.setCode(ex.getCode());
		em.setMessage(ex.getMessage());
		
		return em;
	}
}
