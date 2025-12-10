package com.cf.service;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dto.SignInDto;
import com.cf.dto.SignUpDto;
import com.cf.entity.User;
import com.cf.enums.UserRole;
import com.cf.exception.EmailNotFoundException;
import com.cf.repo.UserRepo;
import com.cf.security.CustomUserDetails;
import com.cf.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthServiceImple implements AuthService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtService jwtService;

	public String signUp(SignUpDto userdto) {

		log.info("Service Layer Received SignUpDto: {}", userdto);

		ModelMapper um = new ModelMapper();
		User user = um.map(userdto, User.class);

		user.setRole(UserRole.Citizen);

		log.info("after DTO : USER : " + user);

		userRepo.save(user);

		return "User Registered Successfully!";
	}

	@Override
	public Map<String, Object> login(SignInDto sidto) {

		Map<String, Object> response = new HashMap<>();

		User user = userRepo.findByEmail(sidto.getEmail());

		if (user == null) {
			response.put("error", "Email not registered!");
			return response;
		}

		if (!user.getPwd().equals(sidto.getPwd())) {
			response.put("error", "Invalid password!");
			return response;
		}

		String token = jwtService.generateToken(user);

		response.put("message", "Login Successful");
		response.put("name", user.getName());
		response.put("email", user.getEmail());
		response.put("token", token);

		return response;
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {

		User user = userRepo.findByEmail(email);

		if (user == null) {
			throw new EmailNotFoundException("Email not found");
		}

		user.setPwd(newPassword); // or setPwdUpdated(newPassword)

		userRepo.save(user);

		return true;
	}

}
