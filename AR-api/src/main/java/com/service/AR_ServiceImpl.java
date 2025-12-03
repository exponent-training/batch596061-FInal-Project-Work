package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import com.AR_Model.CitizenApplication;
import com.AR_Model.CitizenApplicationDTO;
import com.AR_Model.PlanMaster;
import com.AR_Model.User;
import com.repository.AR_Repository;
import com.repository.Plan_Repo;
import com.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AR_ServiceImpl implements AR_Service {

	@Autowired
	private AR_Repository arr;
	
	@Autowired
	private Plan_Repo planrepo;
	
	@Autowired
	private UserRepo Userrepo;

	@Override
	public boolean applicationRegistration(CitizenApplicationDTO citizenDto) {

		log.info("Citizen Service :: " + citizenDto);
//
//		String url = "http://localhost:7777/checkSsn";
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		User authenticatedUser = (User) authentication.getPrincipal();
//		log.info("AUth User : " + authenticatedUser);

		CitizenApplication citizen = new CitizenApplication();
//		ssnWebRequestDto.setCitizenName(citizenDto.getFullname());
//		ssnWebRequestDto.setCitizenDob(citizenDto.getDob() + "");
//		String ssn = String.valueOf(citizenDto.getSsn());
//		ssnWebRequestDto.setCitizenSsnNo(ssn);
		
		citizen.setFullname(citizenDto.getFullname());
		citizen.setDob(citizenDto.getDob());
		citizen.setSsn(citizenDto.getSsn());
		citizen.setGender(citizenDto.getGender());

//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<SsnWebResponseDto> response = rt.postForEntity(url, ssnWebRequestDto, SsnWebResponseDto.class);

//		if (response.getBody().getStateName().equalsIgnoreCase("Rhode Island")) {
//			if (authenticatedUser != null) {
//				ModelMapper model = new ModelMapper();
//				CitizenApplication cap = model.map(citizenDto, CitizenApplication.class);
//
//				cap.setUser(authenticatedUser);
//
//				PlanMaster plan = pr.findByPlanName(citizenDto.getPlanName())
//						.orElseThrow(() -> new PlanNotFoundWithName("Plan Doesnot Exist with this name"));
//				cap.setPlan(plan);
//
//				citizenArRepo.save(cap);
		
		int PlanId=citizenDto.getPlanId();
		int userId=citizenDto.getUserId();

		
		// 2. Plan check
	    PlanMaster plan = planrepo.findById(PlanId).orElseThrow(() -> new RuntimeException("Plan Not Present!!"));;
	    
	    // 3. User check
	    User user = Userrepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Exist!!"));
	   
	    if(citizenDto.getSsn()!=null) {
	    citizen.setPlan(plan);
	    citizen.setUser(user);

            arr.save(citizen);
            log.info("Application Suuccfully Saved !!!!!!");
				return true;
	    }
		return false;

	}
	
	@Override
	public CitizenApplication getApp(Integer appNum) {

		return arr.findById(appNum)
				.orElseThrow(() -> new RuntimeException("Application Number invalid!!"));
	}

	@Override
	public List<CitizenApplication> getApps() {

		return (List<CitizenApplication>) arr.findAll();
	}
}
