package com.spring.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.exception.DepartmentNotFoundException;
import com.spring.exception.ErrorMessage;
import com.spring.exception.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorMessage em = new ErrorMessage();
		em.setCode(ex.getCode());
		em.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(em, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(DepartmentNotFoundException ex) {
		ErrorMessage em = new ErrorMessage();
		em.setCode(ex.getCode());
		em.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(em, HttpStatus.NOT_FOUND);
	}

}
