package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AR_Model.CitizenApplication;

@Repository
public interface AR_Repository extends CrudRepository<CitizenApplication, Integer> {

}
