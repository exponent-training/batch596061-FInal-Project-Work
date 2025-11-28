package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Model.PlanMaster;

@Repository
public interface PlanRepo extends CrudRepository<PlanMaster, Integer>{
	
	

}
