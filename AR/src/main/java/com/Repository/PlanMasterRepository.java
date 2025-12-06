package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.PlanMaster; // PlanMaster entity

@Repository
public interface PlanMasterRepository extends JpaRepository<PlanMaster, Integer> {
}

