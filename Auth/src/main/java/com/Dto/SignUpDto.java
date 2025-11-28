package com.Dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Enum.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpDto {

	@NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Phone number required")
    @Digits(integer = 10, fraction = 0, message = "Phone number must be 10 digits")
    private Long phno;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Min 6 chars")
    private String pwd;

    @NotNull(message = "Role is required")
    private Role role;
}
