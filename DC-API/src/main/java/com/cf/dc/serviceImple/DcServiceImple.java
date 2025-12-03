package com.cf.dc.serviceImple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dc.dto.EducationDto;
import com.cf.dc.dto.IncomeDto;
import com.cf.dc.dto.KidDto;
import com.cf.dc.dto.SummaryResponseDto;
import com.cf.dc.entity.Citizen;
import com.cf.dc.entity.Education;
import com.cf.dc.entity.Income;
import com.cf.dc.entity.Kid;
import com.cf.dc.entity.User;
import com.cf.dc.exception.CitizenApplicationNotFound;
import com.cf.dc.repo.CitizenRepo;
import com.cf.dc.repo.EducationRepo;
import com.cf.dc.repo.IncomeRepo;
import com.cf.dc.repo.KidRepo;
import com.cf.dc.service.DcService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DcServiceImple implements DcService {

	@Autowired
	private IncomeRepo incRepo;

	@Autowired
	private CitizenRepo ctzRepo;

	@Autowired
	private EducationRepo eduRepo;

	@Autowired
	private KidRepo kidRepo;

	@Override
	public boolean saveIncome(IncomeDto income, Integer Appno) {

		log.info("DC Service Income Details : " + income);

		ModelMapper mm = new ModelMapper();

		Income dci = mm.map(income, Income.class);

//		User user = dci.getCitizenApplication().getUser();	

		Citizen citizenApplication = ctzRepo.findByAppNo(Appno)
				.orElseThrow(() -> new CitizenApplicationNotFound("Application Not Found"));

		User user = citizenApplication.getUser();
		log.info("User From Application: " + user);

		List<Citizen> citizenList = ctzRepo.findByUser(user);

		if (citizenList.isEmpty()) {
			throw new CitizenApplicationNotFound("No Applications Found for User");
		}

		Citizen matchedApp = citizenList.stream().filter(c -> c.getAppNo().equals(Appno)).findFirst().get();

		dci.setCitizenApplication(matchedApp);

		incRepo.save(dci);
		return true;

	}

	@Override
	public boolean saveEducation(EducationDto education, Integer appNo, Integer userId) {

		log.info("DC Service Education Details : " + education);

		ModelMapper mm = new ModelMapper();

		Education eduDetails = mm.map(education, Education.class);

		Citizen citizen = ctzRepo.findByAppNo(appNo)
				.orElseThrow(() -> new CitizenApplicationNotFound("Application Not Found for appNo: " + appNo));

		if (citizen.getUser() == null || !Objects.equals(citizen.getUser().getUserId(), userId)) {
			throw new CitizenApplicationNotFound("User does not own the application or user not found");
		}

		eduDetails.setCitizenApplication(citizen);
		eduRepo.save(eduDetails);

		return true;

	}

	@Override
	public boolean saveKid(KidDto kidDto, Integer appNo, Integer userId) {
		log.info("DC Service Kid Details : " + kidDto);

		ModelMapper mm = new ModelMapper();

		Kid kidDetails = mm.map(kidDto, Kid.class);

		Citizen citizen = ctzRepo.findByAppNo(appNo)
				.orElseThrow(() -> new CitizenApplicationNotFound("Application Not Found for appNo: " + appNo));

		if (citizen.getUser() == null || !Objects.equals(citizen.getUser().getUserId(), userId)) {
			throw new CitizenApplicationNotFound("User does not own the application or user not found");
		}

		kidDetails.setCitizenApplication(citizen);
		kidRepo.save(kidDetails);

		return true;
	}

	public SummaryResponseDto getSummaryData(Integer appNo) {

	    ModelMapper mm = new ModelMapper();
	    SummaryResponseDto srd = new SummaryResponseDto();

	    List<Education> eduList = eduRepo.findByCitizenApplication_AppNo(appNo);
	    List<Income> incomeList = incRepo.findByCitizenApplication_AppNo(appNo);
	    List<Kid> kidList = kidRepo.findByCitizenApplication_AppNo(appNo);

	    // Map lists -> DTO lists
	    List<EducationDto> eduDtoList =
	            eduList.stream()
	                   .map(e -> mm.map(e, EducationDto.class))
	                   .collect(Collectors.toList());

	    List<IncomeDto> incomeDtoList =
	            incomeList.stream()
	                      .map(i -> mm.map(i, IncomeDto.class))
	                      .collect(Collectors.toList());

	    List<KidDto> kidDtoList =
	            kidList.stream()
	                   .map(k -> mm.map(k, KidDto.class))
	                   .collect(Collectors.toList());

	    srd.setEducationDetails(eduDtoList);
	    srd.setIncomeDetails(incomeDtoList);
	    srd.setKidDetails(kidDtoList);

	    return srd;
	}




}
