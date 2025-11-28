package com.cf.pm.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cf.pm.enums.ActiveStatus;

import lombok.Data;

@Data
public class PlanDto {

	@NotBlank(message = "Plan name is compulsory")
	@Size(min = 2, max = 50, message = "Plan must be between 2 to 5 characters")

	private String planName;

	@NotNull(message = "Plan start date is required")

	private LocalDate planStartDate;
  //UJ
	@NotNull(message = "Plan end date is required ")

	private LocalDate planEndDate;

	@NotNull(message = "Plan status is required (ACTIVE / INACTIVE)")

	private ActiveStatus activeS;

	@Size(max = 300, message = "Comments cannot be more than 300 characters")
	private String comments;
}
