package com.cf.service;

import com.cf.dto.SignInDto;
import com.cf.dto.SignUpDto;

public interface AuthService {

	public String signUp(SignUpDto sudtoreq);

	public String login(SignInDto sidto);


	boolean resetPassword(String email, String newPassword);

}
