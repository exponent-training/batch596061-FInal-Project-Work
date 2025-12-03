package com.cf.ar.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizen_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "App_no")
	private Integer appNo;

	@NotBlank(message = "Fullname is required")
	@Column(name = "fullname", nullable = false, length = 50)
	@Size(min = 3, max = 50, message = "Fullname must be between 3 to 50 character")
	private String fullName;

	@NotNull(message = "Date Of Birth is required")
	@Past(message = "Date of Birth must be in past")
	@Column(name = "DOB", nullable = false)
	private LocalDate dob;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(?i)(male|female|other)$", message = "Gender must be Male, Female, or Other")
	@Column(name = "gender", nullable = false, length = 15)
	private String gender;;

	@NotNull(message = "SSN is required")
	@Pattern(regexp = "^\\d{9}$", message = "SSN must be exactly 9 digits")
	@Column(name = "ssn", nullable = false, unique = true)
	private String ssn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "User must be linked")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id", nullable = false)
	@NotNull(message = "Plan must be selected")
	private Plans plan;
    
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdDate;
    
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate updatedDate;

}
