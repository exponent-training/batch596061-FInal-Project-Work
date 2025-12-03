package com.IES.DC.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.IES.DC.Enums.ActiveStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan_master_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlanMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id")
	private Integer planId;

	@NotBlank(message = "Plan name is mandatory")
	@Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
	@Column(name = "plan_name", nullable = false)
	private String planName;

	@NotNull(message = "Plan start date is required")
	@Column(name = "plan_start_date")
	private LocalDate planStartDate;

	@NotNull(message = "Plan end date is required")
	@Column(name = "plan_end_date")
	private LocalDate planEndDate;

	@NotNull(message = "Plan status is required (Y or N)")
	@Enumerated(EnumType.STRING)
	@Column(name = "active_sw")
	private ActiveStatus activeSw;

	@Size(max = 255, message = "Comments cannot be more than 255 characters")
	@Column(name = "comments")
	private String comments;

	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDate updatedDate;

}
