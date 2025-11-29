package com.pma.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pma.Enum.ActiveStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanCreateDto {

    @NotBlank(message = "Plan name is mandatory")
    @Size(min = 3, max = 100)
    private String planName;

    @NotNull(message = "Plan start date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate planStartDate;

    @NotNull(message = "Plan end date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate planEndDate;

    @NotNull(message = "Plan status is required")
    private ActiveStatus activeSw;

    @Size(max = 255)
    private String comments;
}


