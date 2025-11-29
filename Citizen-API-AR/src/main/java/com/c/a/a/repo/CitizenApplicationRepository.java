package com.c.a.a.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c.a.a.entity.CitizenApplication;
import com.c.a.a.entity.User;

public interface CitizenApplicationRepository  extends JpaRepository<CitizenApplication, Integer>{
	
	 Optional<CitizenApplication> findByUser(User user);

}
