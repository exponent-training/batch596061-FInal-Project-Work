package com.FinMediNexus.serviceimpl;


import java.util.HashMap;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.FinMediNexus.DTO.ForgetPasswordDTO;
import com.FinMediNexus.DTO.LoginRequestDTO;
import com.FinMediNexus.DTO.LoginResponseDTO;
import com.FinMediNexus.DTO.SignUpDto;
import com.FinMediNexus.Entity.User;
import com.FinMediNexus.Repo.UserRepository;

import com.FinMediNexus.service.AuthenticationService;
import com.FinMediNexus.service.JwtService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthenticationServiceImpl  implements AuthenticationService{

	@Autowired
	 private  UserRepository repo ;
	
	 @Autowired
	 private JwtService jwtService;
	 
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	
	ModelMapper map =new ModelMapper();
	
	
	
	@Override
	public String signUp(@Valid SignUpDto request) {
		
		log.info("i am in service layer ::{}",request.getEmail());
		
		if(repo.existsByEmail(request.getEmail())) {
			
			return "Email alredy registered";
		}
		
		User user =map.map(request, User.class);
		
		 user.setPwd(passwordEncoder.encode(request.getPwd())); // hash password
		
		 repo.save(user);
		 
		 return "User saved succesfully";
	}

	@Override
	public LoginResponseDTO login(@Valid LoginRequestDTO loginRequest) {
	    log.info("Attempting login for email: {}", loginRequest.getEmail());

	    User user = repo.findByEmail(loginRequest.getEmail())
	            .orElseThrow(() -> new RuntimeException("Invalid Email"));

	    if(!passwordEncoder.matches(loginRequest.getPwd(), user.getPwd())) {
	        throw new RuntimeException("Invalid Password");
	    }

	   // CustomerUserDetails userDetails = new CustomerUserDetails(user);
	    String token = jwtService.generateToken(new HashMap<>(), user);

	    LoginResponseDTO res = new LoginResponseDTO();
	    res.setMessage("Login Success");
	    res.setUserId(user.getUserId());
	    res.setRole(user.getRole());
	    res.setToken(token);  // send JWT back to client

	    return res;
	}

	@Override
	public String forgetPassword(@Valid ForgetPasswordDTO forgetpassword) {
		
		User user =repo.findByEmail(forgetpassword.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		user.setPwd(passwordEncoder.encode(forgetpassword.getNewPassword()));
		
		user.setPwdUpdated("yes");
		
		repo.save(user);
		log.info("i am in service layer ::{}",user);
		
		return "Password updated succesfully";
	}

}
