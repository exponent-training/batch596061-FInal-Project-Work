package com.Service;

import java.util.List;

import com.Model.PlanMaster;
import com.Model.PlansDto;

public interface PlanService {

	boolean savePlan(PlansDto pDto);

	List<PlanMaster> getplans();

	PlanMaster getplan(int pid);

	PlanMaster updatePlan(String status, int pid);

	String deletePlan(int pid);

}
