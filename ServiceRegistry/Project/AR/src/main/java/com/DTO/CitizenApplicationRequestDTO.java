package com.DTO;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

//CitizenApplicationRequestDTO
public class CitizenApplicationRequestDTO {
	
	    @NotBlank(message = "Fullname is required")
	    @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
	    @Column(name = "fullname", nullable = false, length = 100)
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

	    // ==============================
	    // Relationships
	    // ==============================

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Integer userId;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "plan_id")
	    private Integer planId;
	    
}


