package com.FinMediNexus.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FinMediNexus.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

}
