package com.cf.dc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cf.dc.entity.Education;
import com.cf.dc.entity.Income;
@Repository
public interface IncomeRepo extends JpaRepository<Income , Integer> {
   
	List<Income> findByCitizenApplication_AppNo(Integer appno);
}
