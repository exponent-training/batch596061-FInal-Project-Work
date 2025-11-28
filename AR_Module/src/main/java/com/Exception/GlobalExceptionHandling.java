package com.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandling
{
	
	public ResponseEntity<?> handlePlanNotFoundException() {

		return new ResponseEntity("Plan Doesnot Exist with this name", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	


	public ResponseEntity<?> handleApplicationNotFoundWithThisId() {

		return new ResponseEntity("Application Doesnot Exist with this ID", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
