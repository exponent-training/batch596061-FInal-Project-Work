package com.cf.service;

import java.util.Map;

import com.cf.dto.SignInDto;
import com.cf.dto.SignUpDto;

public interface AuthService {

	public String signUp(SignUpDto sudtoreq);

	public Map<String, Object> login(SignInDto sidto);


	boolean resetPassword(String email, String newPassword);

}
