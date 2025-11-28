package com.AR_Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class CitizenApplicationDTO {

	@NotBlank(message = "Fullname is required")
	@Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
	private String fullname;

	@NotNull(message = "Date of Birth is required")
	@Past(message = "Date of Birth must be in the past")
	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@NotNull(message = "SSN is required")
	@Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
	@Column(name = "ssn", nullable = false, unique = true)
	private Long ssn;
//
//	// ==============================
//	// Relationships
//	// ==============================
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", nullable = false)
//	@NotNull(message = "User must be linked with application")
//	private User user;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "plan_id", nullable = false)
//	@NotNull(message = "Plan must be selected for application")
//	public PlanMaster plan;
//
//	@CreationTimestamp
//	@Column(name = "created_date", updatable = false)
//	private LocalDate createdDate;
//
//	@UpdateTimestamp
//	@Column(name = "updated_date")
//	private LocalDate updatedDate;

}
