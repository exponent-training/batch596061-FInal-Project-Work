package com.cf.dc.service;

import com.cf.dc.dto.EducationDto;
import com.cf.dc.dto.IncomeDto;
import com.cf.dc.dto.KidDto;
import com.cf.dc.dto.SummaryResponseDto;

public interface DcService {

	public boolean saveIncome(IncomeDto income, Integer Appno);

	public boolean saveEducation(EducationDto kid, Integer Appnum, Integer Userid);

	public boolean saveKid(KidDto kiddto, Integer Appnum, Integer Userid);
	
	public  SummaryResponseDto getSummaryData(Integer appNum);

}
