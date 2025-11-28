package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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
public class Plan
{
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String planName;

    private String planStatus;
}
