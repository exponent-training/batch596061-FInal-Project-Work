package com.cf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cf.exception.GlobalExceptionHandling;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {
   
	@ExceptionHandler(value = EmailNotFoundException.class)
	public ResponseEntity<?> handleEmailNotFound(EmailNotFoundException ex){
		 log.warn("Email ID not exists."+ ex.getMessage());
		return new ResponseEntity("Invalid Email Id " + ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
