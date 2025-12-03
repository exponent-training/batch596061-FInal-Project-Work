package com.service;

import java.util.List;

import com.AR_Model.CitizenApplication;
import com.AR_Model.CitizenApplicationDTO;

public interface AR_Service {

	boolean applicationRegistration(CitizenApplicationDTO dto);
	
	public CitizenApplication getApp(Integer appNum);

	List<CitizenApplication> getApps();

}
