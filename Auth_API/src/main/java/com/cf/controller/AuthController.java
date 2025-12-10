package com.cf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.dto.SignInDto;
import com.cf.dto.SignUpDto;
import com.cf.dto.forgotpwDto;
import com.cf.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/cf/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody SignUpDto sdtoreq) {
		log.info("Controller Layer : " + sdtoreq);
		log.debug("Debug SignUpDto Value : " + sdtoreq);
		return new ResponseEntity(authService.signUp(sdtoreq),HttpStatus.OK);
		//UJ
	}
	 @PostMapping("/signIn")
	    public ResponseEntity<?> login(@RequestBody SignInDto dto) {
	        return new ResponseEntity(authService.login(dto),HttpStatus.OK);
	    }
	 
	 @PutMapping("/forgotpw")
	 @Operation(summary = "Reset Password", description = "Reset password using registered email")
	 public ResponseEntity<?> forgotPassword(@Valid @RequestBody forgotpwDto dto) {

	     log.info("Forgot Password Request: {}", dto.getEmail());

	     boolean reset = authService.resetPassword(dto.getEmail(), dto.getNewPassword());

	     if (reset) {
	         return ResponseEntity.ok("Password reset successfully");
	     }

	     return ResponseEntity.badRequest().body("Failed to reset password");
	 }

		
    	   
    	    
       
	 
	 

}
