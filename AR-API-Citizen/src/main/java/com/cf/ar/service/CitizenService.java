package com.cf.ar.service;

import java.util.List;

import com.cf.ar.dto.CitizenDto;
import com.cf.ar.dto.CitizenResponseDto;


public interface CitizenService {
   
	public boolean createApplication(CitizenDto citizendto);
	
	public CitizenResponseDto getApp(Integer appNum);
	
	public List<CitizenResponseDto> getApps();
	
	public CitizenResponseDto getAppWithCitizenId(Integer citizenId);
}
