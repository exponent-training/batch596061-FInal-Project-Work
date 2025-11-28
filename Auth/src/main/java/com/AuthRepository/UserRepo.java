package com.AuthRepository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByName(String name);
	
	 User findByEmail(String email);

	
}
