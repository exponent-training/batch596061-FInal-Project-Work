package com.IES.DC.Dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class IncomeDto {
	@Min(0)
	@Column(name = "salary_income", nullable = false)
	private Integer salaryIncome;

	@Min(0)
	@Column(name = "property_income", nullable = false)
	private Integer propertyIncome;

}
