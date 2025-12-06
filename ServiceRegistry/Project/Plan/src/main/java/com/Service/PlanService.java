package com.Service;

import java.util.List;

import com.DTO.PlanDTO;


public interface PlanService {

    boolean savePlan(PlanDTO plandto);

    List<PlanDTO> getPlans();

    PlanDTO getPlan(Integer planId);

    boolean updatePlan(Integer planId, PlanDTO plandto);
}
