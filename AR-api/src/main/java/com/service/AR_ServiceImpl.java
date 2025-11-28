package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import com.AR_Model.CitizenApplication;
import com.AR_Model.CitizenApplicationDTO;
import com.repository.AR_Repository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AR_ServiceImpl implements AR_Service {

	@Autowired
	private AR_Repository arr;
	
	@Override
	public void applicationRegistration(CitizenApplicationDTO ctd) {
		
		CitizenApplication cta=new CitizenApplication();
//		
//		cta.setFullname(ctd.getFullname());
//		cta.setGender(ctd.getGender());
//		cta.setSsn(ctd.getSsn());
//		cta.setDob(ctd.getDob());
		log.info("I am in Service layer  :-"+ctd);
		
	}

}
