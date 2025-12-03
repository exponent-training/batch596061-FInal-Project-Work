package com.cf.dc.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EducationDto {

	@NotBlank

	private String highestDegree;

	@NotNull

	private Integer gradYear;

	@NotBlank
	private String uniName;
}
