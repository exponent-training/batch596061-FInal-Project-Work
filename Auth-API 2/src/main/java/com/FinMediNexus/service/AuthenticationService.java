package com.FinMediNexus.service;

import javax.validation.Valid;

import com.FinMediNexus.DTO.ForgetPasswordDTO;
import com.FinMediNexus.DTO.LoginRequestDTO;
import com.FinMediNexus.DTO.LoginResponseDTO;
import com.FinMediNexus.DTO.SignUpDto;

public interface AuthenticationService {
	
	String signUp(@Valid SignUpDto request) ;
	
	LoginResponseDTO login(@Valid LoginRequestDTO loginrequest);
	
	String forgetPassword(@Valid ForgetPasswordDTO forgetpassword);
		
	

}
