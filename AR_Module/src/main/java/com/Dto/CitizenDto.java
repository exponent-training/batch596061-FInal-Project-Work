package com.Dto;

import com.Entity.Plan;
import com.Entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CitizenDto 
{
	@NotBlank(message = "Fullname is required")
	@Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
	@Column(name = "fullname", nullable = false, length = 100)
	private String fullname;

	@NotNull(message = "Date of Birth is required")
//	@Past(message = "Date of Birth must be in the past")
	@Column(name = "dob", nullable = false)
	private String dob;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@NotNull(message = "SSN is required")
	@Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
	@Column(name = "ssn", nullable = false, unique = true)
	private Long ssn;
	
	
	@NotBlank(message = "planName is required")
	@Size(min = 3, max = 100, message = "planName must be between 3 and 100 characters")
	@Column(name = "planName", nullable = false, length = 100)
	private String planName;

	// ==============================
	// Relationships
	// ==============================
	
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "User must be linked with application")
	private User user;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id", nullable = false)
	@NotNull(message = "Plan must be selected for application")
	private Plan plan;

}
