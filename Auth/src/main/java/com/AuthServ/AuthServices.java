package com.AuthServ;

import javax.validation.Valid;

import com.Dto.ForgetPasswordDto;
import com.Dto.LoginReqDto;
import com.Dto.SignUpDto;
import com.Entity.User;

public interface AuthServices {

	String signUp(@Valid SignUpDto sUDto);

	User LoginReqDto(@Valid LoginReqDto lRDto);
	
	String forgetPassword(@Valid ForgetPasswordDto forgetPasswordDto);

}
