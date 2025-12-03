package com.cf.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dc_income")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "income_id")
	private Integer incomeId;

	@Min(0)
	@Column(name = "salary_income", nullable = false)
	private Integer salaryIncome;

	@Min(0)
	@Column(name = "property_income", nullable = false)
	private Integer propertyIncome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_number", nullable = false)
	private Citizen citizenApplication;
}
