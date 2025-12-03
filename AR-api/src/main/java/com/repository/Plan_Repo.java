package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AR_Model.PlanMaster;

@Repository
public interface Plan_Repo extends JpaRepository<PlanMaster, Integer> {

}
