package com.cf.ar.serviceImple;

import java.util.List;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cf.ar.dto.CitizenDto;
import com.cf.ar.dto.CitizenResponseDto;
import com.cf.ar.entity.Citizen;
import com.cf.ar.entity.Plans;
import com.cf.ar.entity.User;
import com.cf.ar.exception.AppNotFoundException;
import com.cf.ar.exception.PlanNotFoundWithName;
import com.cf.ar.exception.UserNotFound;
import com.cf.ar.exception.WrongSsnException;
import com.cf.ar.repo.CitizenRepo;
import com.cf.ar.repo.PlanRepo;
import com.cf.ar.repo.UserRepo;
import com.cf.ar.service.CitizenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitizenServiceImple implements CitizenService {

	@Autowired
	private PlanRepo pr;

	@Autowired
	private CitizenRepo cr;

	@Autowired
	private UserRepo ur;

	@Override
	public boolean createApplication(CitizenDto citizendto) {

		log.info("Citizen Service : {}", citizendto);

		String ssn = citizendto.getSsn();
	    if (!ssn.startsWith("12")) {
	        throw new WrongSsnException("Invalid SSN! This SSN does not belong to Rhode Island.");
	    }

	    String stateName = "Rhode Island";
	    
	    log.info("State based on SSN: {}", stateName);

	

		if (stateName.equalsIgnoreCase("Rhode Island")) {

			User user = ur.findByUserId(citizendto.getUserId())
					.orElseThrow(() -> new UserNotFound("User not found for ID: " + citizendto.getUserId()));

			ModelMapper mapper = new ModelMapper();
			Citizen ctz = mapper.map(citizendto, Citizen.class);

		
			ctz.setUser(user);

		
			Plans plan = pr.findByPlanName(citizendto.getPlanName())
					.orElseThrow(() -> new PlanNotFoundWithName("Plan Doesn’t Exist with name: " + citizendto.getPlanName()));

			ctz.setPlan(plan);

			cr.save(ctz);
              //UJ
			return true;
		}

		return false;
	}


	@Override
	public CitizenResponseDto getApp(Integer appNo) {

	    Citizen citizen = cr.findById(appNo)
	            .orElseThrow(() -> new AppNotFoundException("Application not found: " + appNo));

	    CitizenResponseDto dto = new CitizenResponseDto();

	    dto.setCitizenNo(citizen.getCitizenNo());
	    dto.setFullName(citizen.getFullName());
	    dto.setDob(citizen.getDob());
	    dto.setGender(citizen.getGender());
	    dto.setSsn(citizen.getSsn());
	    dto.setUserId(citizen.getUser().getUserId());
	    dto.setUserName(citizen.getUser().getName());
	    dto.setPlanId(citizen.getPlan().getPlanId());
	    dto.setPlanName(citizen.getPlan().getPlanName());

	    return dto;

	}

	@Override
	public List<CitizenResponseDto> getApps() {

	    List<Citizen> citizens = cr.findAll();

	    List<CitizenResponseDto> dtos = new ArrayList<>();

	    for (Citizen citizen : citizens) {
	        CitizenResponseDto dto = new CitizenResponseDto();

	        dto.setCitizenNo(citizen.getCitizenNo());
	        dto.setFullName(citizen.getFullName());
	        dto.setDob(citizen.getDob()); 
	        dto.setGender(citizen.getGender());
	        dto.setSsn(citizen.getSsn());

	        dto.setUserId(citizen.getUser().getUserId());
	        dto.setUserName(citizen.getUser().getName());
            //UJ
	        dto.setPlanId(citizen.getPlan().getPlanId());
	        dto.setPlanName(citizen.getPlan().getPlanName());

	        dtos.add(dto);
	    }

	    return dtos;
	}
	
	@Override
	public CitizenResponseDto getAppWithCitizenId(Integer citizenId) {

	    Citizen citizen = cr.findById(citizenId)
	            .orElseThrow(() -> new AppNotFoundException("Citizen not found: " + citizenId));

	    CitizenResponseDto dto = new CitizenResponseDto();

	    dto.setCitizenNo(citizen.getCitizenNo());
	    dto.setFullName(citizen.getFullName());
	    dto.setDob(citizen.getDob());
	    dto.setGender(citizen.getGender());
	    dto.setSsn(citizen.getSsn());
	    dto.setUserId(citizen.getUser().getUserId());
	    dto.setUserName(citizen.getUser().getName());
	    dto.setPlanId(citizen.getPlan().getPlanId());
	    dto.setPlanName(citizen.getPlan().getPlanName());

	    return dto;
	}


}
