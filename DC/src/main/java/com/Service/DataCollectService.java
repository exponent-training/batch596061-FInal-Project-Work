package com.Service;

import com.DTO.EducationDTO;
import com.DTO.IncomeDTO;
import com.DTO.KidsDTO;
import com.DTO.SummeryDTO;

public interface DataCollectService {
	boolean saveIncome(IncomeDTO income,Integer Appnum , Integer Userid);
	boolean saveEducation(EducationDTO education,Integer Appnum , Integer Userid);
	boolean saveKids(KidsDTO kiddto,Integer Appnum , Integer Userid);
	SummeryDTO getSummaryData(Integer appNum);
}
