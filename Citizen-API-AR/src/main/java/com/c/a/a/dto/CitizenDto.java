package com.c.a.a.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenDto {

    @NotBlank(message = "Fullname is required")
    private String fullname;

    @NotNull(message = "DOB is required")
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "SSN is required")
    private Long ssn;

    @NotBlank(message = "Plan name is required")
    private String planName;
    
    

    @NotNull(message = "User ID is required")
    private Integer userId;
}