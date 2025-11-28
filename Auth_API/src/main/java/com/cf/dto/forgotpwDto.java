package com.cf.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class forgotpwDto {

	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "New password is required")
	private String newPassword;

}
