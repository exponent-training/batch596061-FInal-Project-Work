package com.exponent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.entity.User;
import com.exponent.entity.UserDto;
import com.exponent.enums.Role;
import com.exponent.repositery.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public String Register(UserDto udto) {

		User user = new User();

		user.setName(udto.getName());
		user.setEmail(udto.getEmail());
		user.setPhno(udto.getPhno());
		user.setPwd(udto.getPwd());
		user.setRole(Role.CITIZEN);

		userRepo.save(user);
		return "User Saved successfully!!!!!!!";
	}

	@Override
	public User login(String email, String pwd) {
		log.info("I am Service Layer !!!!!");

		User user = userRepo.findByEmail(email);

		if (user == null) {
			log.info("Invalid Mail!! Register First!!");
			return null;
		}

		if (!user.getPwd().equals(pwd)) {
			log.info("Invalid Password !!!!!");
			return null;

		}
		log.info("Login Successfully !!!");
		return user;

	}

	@Override
	public String forgetpass(String email, String old,String pwdUpdated) {
		log.info("I am in Service Layer!!!");

		User user = userRepo.findByEmail(email);

		if (user == null) {
			log.info("Email Not Found!!!");
		
		}if(!user.getPwd().equals(old)) {
			log.info("Invalid Old Password!!!");
		}
		else {
			user.setPwdUpdated(pwdUpdated);
			user.setPwd(pwdUpdated);
			userRepo.save(user);
			return "Password Updated Successsfully!!!!!!";
		}
		return "Invalid Crediantals!!!!";
	}
}
