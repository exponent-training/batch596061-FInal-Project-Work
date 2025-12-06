package com.DTO;

import javax.persistence.Column;
import javax.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestDTO {

	@Column(name = "email", unique = true, nullable = false, length = 150)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;


	@Column(name = "pwd", nullable = false)
	@NotBlank(message = "pwd is required")
	@Size(min = 6, message = "pwd must be at least 6 characters")
	private String pwd;
	
}
