package com.cf.pm.service;

import java.util.List;

import javax.validation.Valid;

import com.cf.pm.dto.PlanDto;
import com.cf.pm.dto.UpdatePlanDto;

public interface PlanService {

	public boolean savePlan(PlanDto plandto);

	public List<PlanDto> getPlans();

	public PlanDto getPlan(Integer planId);

	public boolean updatePlan(Integer planId, @Valid UpdatePlanDto updateDto);
	
	

}
