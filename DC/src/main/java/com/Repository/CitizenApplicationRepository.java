package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.CitizenApplication;
import com.Entity.User;

@Repository
public interface CitizenApplicationRepository extends JpaRepository<CitizenApplication,Integer> {
	List<CitizenApplication> findByUser(User user);
}
