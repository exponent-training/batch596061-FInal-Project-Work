package com.cf.ar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cf.ar.entity.User;

	public interface UserRepo extends JpaRepository<User, Integer> {

		Optional<User> findByUserId(Integer user_id);
		User findByEmail(String email);
	}


