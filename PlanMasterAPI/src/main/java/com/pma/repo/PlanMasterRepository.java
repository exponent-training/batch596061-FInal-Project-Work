package com.pma.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pma.entity.PlanMaster;

public interface PlanMasterRepository  extends JpaRepository<PlanMaster, Integer>{
	
boolean existsByPlanName(String planName);

Optional <PlanMaster> findByPlanName(String planName);
}
