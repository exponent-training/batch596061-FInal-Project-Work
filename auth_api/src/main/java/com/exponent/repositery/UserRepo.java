package com.exponent.repositery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exponent.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	
	 public User findByEmail(String email);

}
