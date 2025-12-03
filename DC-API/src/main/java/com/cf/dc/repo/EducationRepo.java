package com.cf.dc.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cf.dc.entity.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education , Integer> {
 
	List<Education> findByCitizenApplication_AppNo(Integer appno);


}
 