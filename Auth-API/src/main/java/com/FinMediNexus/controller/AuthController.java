package com.FinMediNexus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FinMediNexus.DTO.ForgetPasswordDTO;
import com.FinMediNexus.DTO.LoginRequestDTO;
import com.FinMediNexus.DTO.LoginResponseDTO;
import com.FinMediNexus.DTO.SignUpDto;
import com.FinMediNexus.service.AuthenticationService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class AuthController {
	
	@Autowired
	private AuthenticationService as;
	
	
	@PostMapping("/signup")
	public String signUp(@Valid @RequestBody SignUpDto request) {
		
		log.info("  i am in controller layer :: { }",request);
		
		
		return as.signUp(request);
		
	}
	
	@PostMapping("/login")
	public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO  request) {
		
		log.info("  iam in controller layer ::{ }",request);
		
		
		return as.login(request);
		
	}
	@PostMapping("/forget")
	public String forgetPassword(@Valid @RequestBody ForgetPasswordDTO request) {

		log.info("  i am in controller layer ::{ }",request);
		
		return as.forgetPassword(request);
		
	}

}
