package com.pma.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pma.exception.DuplicatePlanException;
import com.pma.exception.planNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(planNotFoundException.class)
	public ResponseEntity<?> handlePlanNotFound(planNotFoundException ex){
		
		
		return ResponseEntity.status(404).body(ex.getMessage());
		
	}
	@ExceptionHandler(DuplicatePlanException.class)
	public ResponseEntity<?> hondleDuplicatePlanException(DuplicatePlanException ex){

		return ResponseEntity.status(400).body(ex.getMessage());
		
}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex){

		Map<String,String> errors=new HashMap<>();
		
        ex.getBindingResult().getFieldErrors().
        forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		
		return ResponseEntity.status(400).body(errors);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleotherErrors(Exception ex){
		
		return ResponseEntity.status(500).body("Something went wrong");
	}
		
	}
	