package com.cf.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cf.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
