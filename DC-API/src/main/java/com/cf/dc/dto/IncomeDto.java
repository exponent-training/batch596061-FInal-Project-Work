package com.cf.dc.dto;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class IncomeDto {
 
	@Min(0)
	private Integer salaryIncome;

	@Min(0)
	private Integer propertyIncome;
	
}
