package com.c.a.a.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c.a.a.entity.PlanMaster;
import com.c.a.a.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> name(String username);

	Optional<User> findByName(String name);
}
