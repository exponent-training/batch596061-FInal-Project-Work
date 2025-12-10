package com.cf.dc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.dc.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
