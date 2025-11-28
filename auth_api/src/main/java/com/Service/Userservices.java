package com.Service;

import javax.validation.Valid;

import com.DTO.*;

public interface Userservices {

    String signUp(@Valid SignUpDto signUpRequest);

    LoginResposneDTO login(@Valid LoginRequestDTO loginRequest);

    String forgetPassword(@Valid ForgetpasswordDto forgetPasswordDto);
}
