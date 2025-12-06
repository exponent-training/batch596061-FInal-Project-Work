package com.DTO;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

//CitizenApplicationResponseDTO
public class CitizenApplicationResponseDTO {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "app_number")
	    private Integer appNumber;

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

	    @NotBlank(message = "Plan name is mandatory")                                                 //Plan
	    @Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
	    @Column(name = "plan_name", nullable = false)
	    private String planName;

    
	    @Column(name = "email", unique = true, nullable = false, length = 150)                       //User
		@Email(message = "Invalid email format")
		@NotBlank(message = "Email is required")
		private String email;
    
	    @Column(name = "created_date", updatable = false)
	    private LocalDate createdDate;

}


