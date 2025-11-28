package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
