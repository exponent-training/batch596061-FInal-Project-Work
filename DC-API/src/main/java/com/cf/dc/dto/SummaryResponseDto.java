package com.cf.dc.dto;

import java.util.List;

import com.cf.dc.entity.Education;
import com.cf.dc.entity.Income;
import com.cf.dc.entity.Kid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryResponseDto {

    private List<EducationDto> educationDetails;
    private List<IncomeDto> incomeDetails;
    private List<KidDto> kidDetails;
}
