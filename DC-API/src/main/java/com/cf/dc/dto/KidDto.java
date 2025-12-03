package com.cf.dc.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class KidDto {

	@NotBlank
	@Size(min = 2, max = 50)
	private String kidName;

	@Past
	private LocalDate kidDob;
	private Long kidSsn;
}
