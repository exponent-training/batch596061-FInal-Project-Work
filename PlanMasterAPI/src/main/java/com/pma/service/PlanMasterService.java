package com.pma.service;

import java.util.List;

import com.pma.dto.PlanCreateDto;
import com.pma.dto.PlanDto;

public interface PlanMasterService {
	
	boolean savePlan(PlanCreateDto plancreateDto);

    List<PlanDto> getPlans();

    PlanDto getPlan(Integer planId);

    boolean updatePlan(Integer planId, PlanCreateDto plancreateDto);

}
