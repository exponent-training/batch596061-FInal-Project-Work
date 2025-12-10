package com.cf.pm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.pm.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
   
	User findByEmail(String email);
}
