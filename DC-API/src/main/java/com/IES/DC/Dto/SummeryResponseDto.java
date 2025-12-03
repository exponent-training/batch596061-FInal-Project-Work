package com.IES.DC.Dto;

import java.util.List;

import com.IES.DC.Entity.DcEducation;
import com.IES.DC.Entity.DcIncome;
import com.IES.DC.Entity.DcKid;

import lombok.Data;

@Data
public class SummeryResponseDto {

	private List<DcEducation> educationDetails;

	private List<DcKid> kidDetails;

	private List<DcIncome> IncomdeDetails;

}
