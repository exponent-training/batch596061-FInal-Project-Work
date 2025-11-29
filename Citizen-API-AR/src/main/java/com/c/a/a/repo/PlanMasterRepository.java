package com.c.a.a.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c.a.a.entity.PlanMaster;

public interface PlanMasterRepository  extends JpaRepository<PlanMaster, Integer>{
	
	 Optional<PlanMaster> findByPlanName(String planName);
}
