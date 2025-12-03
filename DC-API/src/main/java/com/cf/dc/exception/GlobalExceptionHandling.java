package com.cf.dc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {
     
	@ExceptionHandler(value = CitizenApplicationNotFound.class)
	public ResponseEntity<?> handleCitizenApplicationNotFound(CitizenApplicationNotFound ex){
		log.warn("Application of Citizen Not Found " + ex.getMessage());
		return new ResponseEntity("Application Not Found" + ex.getMessage() ,HttpStatus.NOT_FOUND);
	}
}
