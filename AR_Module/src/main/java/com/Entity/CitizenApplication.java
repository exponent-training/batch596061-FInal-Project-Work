package com.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizen_apps_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_number")
	private Integer appNumber;

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

	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDate updatedDate;
}
