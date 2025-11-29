package com.c.a.a.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.c.a.a.dto.CitizenDto;

import com.c.a.a.entity.CitizenApplication;
import com.c.a.a.entity.PlanMaster;
import com.c.a.a.entity.User;
import com.c.a.a.exception.ApplicationNotFoundException;
import com.c.a.a.exception.InvalidStateException;
import com.c.a.a.exception.PlanNotFoundException;
import com.c.a.a.exception.UserNotFoundException;
import com.c.a.a.repo.CitizenApplicationRepository;
import com.c.a.a.repo.PlanMasterRepository;
import com.c.a.a.repo.UserRepository;
import com.c.a.a.service.CitizenApplicationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CitizenApplicationServiceImpl implements CitizenApplicationService {

	@Autowired
	private CitizenApplicationRepository cr;

	@Autowired
	private UserRepository ur;

	@Autowired
	private PlanMasterRepository pr;

	
	ModelMapper mapper = new ModelMapper();


	@Override
	public boolean createApplication(CitizenDto citizenDto) {

		log.info(" I am inService Layer::{}", citizenDto);
		// 1. Check state by SSN
		// 1. Validate SSN (Rhode Island rule)
		if (citizenDto.getSsn() == null || citizenDto.getSsn() < 1000000L || citizenDto.getSsn() > 3999999L) {
			throw new InvalidStateException("Citizen does not belong to Rhode Island");
		}

		// show user by userId
		Integer userId = citizenDto.getUserId();
		User user = ur.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found for ID: " + userId));

		// show plan by planName
		String planName = citizenDto.getPlanName();
		PlanMaster plan = pr.findByPlanName(planName)
				.orElseThrow(() -> new PlanNotFoundException("Plan not found with name: " + planName));

		//  simple fields are mapped automatically
		CitizenApplication citizenApp = mapper.map(citizenDto, CitizenApplication.class);

		// Set associations manually
		citizenApp.setUser(user);
		citizenApp.setPlan(plan);

		log.info("Saving citizen application: {}", citizenApp);

		cr.save(citizenApp);

		return true;

	}

	@Override
	public CitizenApplication getApp(Integer appNumber) {

		log.info(" I am inService Layer::{}", appNumber);

		return cr.findById(appNumber)
				.orElseThrow(() -> new ApplicationNotFoundException("Application Number Invalid.."));

	}

	@Override
	public List<CitizenApplication> getApps() {

		log.info(" I am inService Layer::{}");

		List<CitizenApplication> apps = cr.findAll();

		if (apps.isEmpty()) {
			throw new ApplicationNotFoundException("No applications found");
		}
		return apps;
	}

	@Override
	public CitizenApplication getAppWithCitizenId(Integer citizenId) {

		log.info(" I am inService Layer::{}", citizenId);

		User user = ur.findById(citizenId).orElseThrow(() -> new UserNotFoundException("citizen Id is invalid"));
		
		//here citizenId means userId

		CitizenApplication app = cr.findByUser(user)
				.orElseThrow(() -> new ApplicationNotFoundException("application not found for these Id"));

		return app;

	}

}
