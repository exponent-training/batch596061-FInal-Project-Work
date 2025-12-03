package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AR_Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
