package com.cf.dc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cf.dc.entity.Citizen;
import com.cf.dc.entity.User;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
      
	Optional<Citizen> findByAppNo(Integer appNo);
	List<Citizen> findByUser(User user);

}
