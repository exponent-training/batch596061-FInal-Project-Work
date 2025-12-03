package com.cf.dc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cf.dc.entity.Kid;

public interface KidRepo extends JpaRepository<Kid , Integer>{
   
	List<Kid> findByCitizenApplication_AppNo(Integer appno);
}
