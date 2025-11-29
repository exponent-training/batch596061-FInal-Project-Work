package com.FinMediNexus.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ForgetPasswordDTO {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String newPassword;
}
