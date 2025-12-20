package com.FinMediNexus.DTO;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.FinMediNexus.Enum.Role;

import lombok.Data;


@Data
public class SignUpDto {
	
	
	 @NotBlank
	    private String name;

	    @Email
	    @NotBlank
	    private String email;

	    @NotNull
	    private Long phno;

	    @NotBlank
	    private String pwd;

	    @NotNull
	    private Role role;

}
