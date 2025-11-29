package com.c.a.a.globalexception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.c.a.a.exception.ApplicationNotFoundException;
import com.c.a.a.exception.InvalidStateException;
import com.c.a.a.exception.PlanNotFoundException;
import com.c.a.a.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionhandler {
	
	// Invalid State 400
    @ExceptionHandler(InvalidStateException.class)
    public ResponseEntity<Object> handleInvalidState(InvalidStateException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Plan Not Found
    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<Object> handlePlanNotFound(PlanNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // User Not Found 404
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Application Not Found 404
    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<Object> handleApplicationNotFound(ApplicationNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Validation Errors (@Valid)400 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );

        errorDetails.put("errors", errors);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception ex) {
        return buildResponse("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Common Response Builder
    private ResponseEntity<Object> buildResponse(String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", message);

        return new ResponseEntity<>(body, status);
    }

}
