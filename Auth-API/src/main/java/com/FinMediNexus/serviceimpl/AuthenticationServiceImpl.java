package com.FinMediNexus.serviceimpl;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinMediNexus.DTO.ForgetPasswordDTO;
import com.FinMediNexus.DTO.LoginRequestDTO;
import com.FinMediNexus.DTO.LoginResponseDTO;
import com.FinMediNexus.DTO.SignUpDto;
import com.FinMediNexus.Entity.User;
import com.FinMediNexus.Repo.UserRepository;
import com.FinMediNexus.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthenticationServiceImpl  implements AuthenticationService{

	@Autowired
	 private  UserRepository repo ;
	
	ModelMapper map =new ModelMapper();
	
	
	
	@Override
	public String signUp(@Valid SignUpDto request) {
		
		log.info("i am in service layer ::{}",request);
		
		if(repo.existsByEmail(request.getEmail())) {
			
			return "Email alredy registered";
		}
		
		User user =map.map(request, User.class);
		
		 repo.save(user);
		 
		 return "User saved succesfully";
	}

	@Override
	public LoginResponseDTO login(@Valid LoginRequestDTO loginrequest) {
		
		log.info("i am in service layer ::{}",loginrequest);
		
		User user =repo.findByEmail(loginrequest.getEmail())
				
				.orElseThrow(()-> new RuntimeException("Invalid Email.."));
		
		if(!user.getPwd().equals(loginrequest.getPwd())){
			throw new RuntimeException("Invalid Password");
			
		}
		LoginResponseDTO res=new LoginResponseDTO();
		res.setMessage("Login Success");
		res.setUserId(user.getUserId());
		res.setRole(user.getRole());
		
		return res;
	}

	@Override
	public String forgetPassword(@Valid ForgetPasswordDTO forgetpassword) {
		
		User user =repo.findByEmail(forgetpassword.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		user.setPwd(forgetpassword.getNewPassword());
		
		user.setPwdUpdated("yes");
		
		repo.save(user);
		log.info("i am in service layer ::{}",user);
		
		return "Password updated succesfully";
	}

}
