package com.pma.entity;

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

import com.pma.Enum.ActiveStatus;

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
public class PlanMaster {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "plan_id")
	    private Integer planId;

	    @Column(name = "plan_name", nullable = false)
	    private String planName;

	    @Column(name = "plan_start_date", nullable = false)
	    private LocalDate planStartDate;

	    @Column(name = "plan_end_date", nullable = false)
	    private LocalDate planEndDate;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "active_sw", nullable = false)
	    private ActiveStatus activeSw;

	    @Column(name = "comments")
	    private String comments;

	    @Column(name = "created_date", updatable = false)
	    private LocalDate createdDate;

	    @Column(name = "updated_date")
	    private LocalDate updatedDate;
   
}
