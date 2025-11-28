package com.Dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.Entity.ActiveStatus;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PlanDto {

	private Integer planId;
    private String planName;
    private String planStatus;

}
