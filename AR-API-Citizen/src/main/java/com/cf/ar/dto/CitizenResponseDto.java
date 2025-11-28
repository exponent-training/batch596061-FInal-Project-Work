
package com.cf.ar.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenResponseDto {

	private Integer citizenNo;
	private String fullName;
	private LocalDate dob;
	private String gender;
	private String ssn;

	private Integer userId;
	private String userName;

	private Integer planId;
	private String planName;

}
