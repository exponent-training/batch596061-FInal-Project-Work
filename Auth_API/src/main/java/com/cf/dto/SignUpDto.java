package com.cf.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Data
public class SignUpDto {

	@Column(name = "name", nullable = false, length = 100)
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 50, message = "Name must be 3-50 characters")
	private String name;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;

	@Column(name = "phno")
	@NotNull(message = "Phone number required")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be 10 digits")
	private Long phno;

	@Column(name = "pwd", nullable = false)
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String pwd;

	
}
