package com.infy.ekart.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.ekart.dto.ErrorMessage;


@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	private Environment environment;


	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(UserException ex) {
	
			 ErrorMessage error = new ErrorMessage();
	        // error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	         error.setMessage(ex.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		 
	}


}

