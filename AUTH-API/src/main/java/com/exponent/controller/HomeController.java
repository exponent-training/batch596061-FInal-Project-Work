package com.exponent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.entity.User;
import com.exponent.entity.UserDto;
import com.exponent.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/user")
public class HomeController {
	
	@Autowired
	private UserService us;

	@PostMapping(value="/register")
	public String register(@RequestBody UserDto udto){
		log.info("I am in Controller");
		us.Register(udto);
		return "User Saved!!";
		
	}
	
	@GetMapping(value="/get")
	public String login(@RequestParam String email, String pwd) {
		log.info("I am in home controller ");
		User user=us.login(email,pwd);
		String s=null;
		if (user!=null) {
			s="Login Successfull!!!!!!";
		} else {
          s="Invalid Creaditials!! Try Again";
		}
		return s;
	}
	
	@PostMapping(value="/forget")
	public String forgetPass(@RequestParam String email,String oldpwd,String pwdUpdated) {
		
		log.info("I am in Home Controller!!");
		String msg=us.forgetpass(email,oldpwd,pwdUpdated);
	
		return msg;
	}
}
