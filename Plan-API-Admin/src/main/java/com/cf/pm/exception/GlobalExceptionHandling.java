package com.cf.pm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {
  
	@ExceptionHandler(value = PlanDoesNotExist.class)
	public ResponseEntity<?> handlePlanDoesNotExist(PlanDoesNotExist ex){
		 log.warn("Plan Does not Exist with this ID No."+ ex.getMessage());
		return new ResponseEntity("Invalid Plan Id Entered" + ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
