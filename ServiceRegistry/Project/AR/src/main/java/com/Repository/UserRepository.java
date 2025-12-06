package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.User;  // Import your User entity

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

