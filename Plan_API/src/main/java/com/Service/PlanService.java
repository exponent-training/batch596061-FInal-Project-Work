package com.Service;

import com.Dto.PlanDto;

import antlr.collections.List;

public interface PlanService
{
	public boolean savePlan(PlanDto plandto);

	public java.util.List getPlans();

	public PlanDto getPlan(Integer planId);

	public boolean updatePlan(Integer planId, String status);
}
