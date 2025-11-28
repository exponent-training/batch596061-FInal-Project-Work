package com.IES.CM.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.CitizenApplication;
import com.Entity.PlanMaster;
import com.Entity.User;
import com.IES.CM.Dto.citizenDto;
import com.IES.CM.Exception.UserNotFoundThisId;
import com.IES.CM.Services.citizenArService;
import com.IES.CM.repository.CitizenApplicationRepo;
import com.IES.CM.repository.PlanMasterRepo;
import com.IES.CM.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class citizenArServiceImpl implements citizenArService {
	@Autowired
    private CitizenApplicationRepo repo;  
	
    @Autowired
    private PlanMasterRepo planRepo;      

    @Autowired
    private UserRepo userRepo;  

    @Override
    public boolean createApplication(citizenDto cDto) {

        if (!isFromRhodeIsland(cDto.getSsn())) {
            return false;
        }

        // Check SSN exists or not
        CitizenApplication citizen = repo.findBySsn(cDto.getSsn());

        // Find User
        User user = userRepo.findByEmail(cDto.getEmail().trim());
        if (user == null) {
            throw new RuntimeException("User not found with email: " + cDto.getEmail());
        }

        // SSN EXISTS – validate user
        if (citizen != null) {
            if (!citizen.getUser().getUserId().equals(user.getUserId())) {
                throw new RuntimeException(
                    "SSN already registered with another user: " + cDto.getSsn()
                );
            }
        }

        // Map DTO → Entity
        ModelMapper model = new ModelMapper();
        CitizenApplication cap = model.map(cDto, CitizenApplication.class);

        // Set user
        cap.setUser(user);

        // Validate and set plan
        PlanMaster plan = planRepo.findByPlanName(cDto.getPlanName());
        if (plan == null) {
            throw new RuntimeException("Plan not found: " + cDto.getPlanName());
        }
        cap.setPlan(plan);

        // Save record
        repo.save(cap);
        return true;
    }

	
	
	
	public boolean isFromRhodeIsland(long ssnLong) {

	    // Convert long to 9-digit string with leading zeros
	    String ssn = String.format("%09d", ssnLong);

	    // Extract first 3 digits (area number)
	    String area = ssn.substring(0, 3);

	    return area.equals("035") || area.equals("036");
	}



	@Override
	public CitizenApplication getApplication(Integer appNum) {
	
		
		CitizenApplication app = repo.findById(appNum)
			    .orElseThrow(() -> new RuntimeException("Application not found with ID: " + appNum));
			return app;

	}



	@Override
	public List<CitizenApplication> getAllApplication() {
		List<CitizenApplication> applications = repo.findAll();
		if (applications.isEmpty()) {
	        throw new RuntimeException("No applications found");
	    }

	    return applications;
	}



	@Override
	public CitizenApplication getAppWithCitizenId(Integer citizenId) {
		User user = userRepo.findById(citizenId).orElseThrow(() -> new UserNotFoundThisId("Citizen id invalid"));
		CitizenApplication citizen = repo.findByUser(user).orElseThrow(() -> new UserNotFoundThisId("Citizen id invalid"));;
		return citizen;
	}




	
}
