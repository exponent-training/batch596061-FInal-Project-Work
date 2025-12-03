package com.exponent.service;


import org.springframework.stereotype.Service;

import com.exponent.entity.User;
import com.exponent.entity.UserDto;

@Service
public interface UserService {

	public String Register(UserDto udto);

	public User login(String email, String pwd);

	public String forgetpass(String email, String pwd, String pwdUpdated);


}
