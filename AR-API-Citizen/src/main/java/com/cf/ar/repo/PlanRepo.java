package com.cf.ar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cf.ar.entity.Plans;

public interface PlanRepo extends JpaRepository<Plans, Integer> {

	 Optional<Plans> findByPlanName(String planName);
}
