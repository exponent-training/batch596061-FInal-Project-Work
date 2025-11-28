package com.cf.pm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.pm.entity.Plans;

public interface PlanRepo extends JpaRepository<Plans, Integer> {

}
