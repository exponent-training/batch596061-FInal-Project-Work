package com.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReqDto {

	@NotBlank(message = "Name is required")
    private String name;

	 @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Min 6 chars")
	    private String pwd;
}
