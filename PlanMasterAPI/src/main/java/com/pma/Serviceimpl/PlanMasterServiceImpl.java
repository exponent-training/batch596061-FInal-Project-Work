package com.pma.Serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.dto.PlanCreateDto;
import com.pma.dto.PlanDto;
import com.pma.entity.PlanMaster;
import com.pma.exception.DuplicatePlanException;
import com.pma.exception.planNotFoundException;
import com.pma.repo.PlanMasterRepository;
import com.pma.service.PlanMasterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PlanMasterServiceImpl implements PlanMasterService {

	@Autowired
	private PlanMasterRepository repo;

	ModelMapper map = new ModelMapper();

	@Override
	public boolean savePlan(PlanCreateDto plancreateDto) {

		log.info("I am inService Layer ::{}", plancreateDto);

		if (plancreateDto.getPlanStartDate().isAfter(plancreateDto.getPlanEndDate())) {

			throw new IllegalArgumentException("start date cannot be afterend date ");

		}
		if (repo.existsByPlanName(plancreateDto.getPlanName())) {
			throw new DuplicatePlanException("plan with Name " + plancreateDto.getPlanName());
		}

		PlanMaster planmaster = map.map(plancreateDto, PlanMaster.class);

		LocalDate now = LocalDate.now();

		planmaster.setCreatedDate(now);
		planmaster.setUpdatedDate(now);

		repo.save(planmaster);

		log.info("I am inService Layer ::{}", planmaster);

		return true;

	}

	@Override
	public List<PlanDto> getPlans() {

		log.info("I am inService Layer ::{}");

		return repo.findAll().stream().map(e -> map.map(e, PlanDto.class)).collect(Collectors.toList());
	}

	@Override
	public PlanDto getPlan(Integer planId) {

		log.info("I am inService Layer ::{}", planId);

		PlanMaster plan = repo.findById(planId).orElseThrow(() -> new planNotFoundException("Plan not found"));

		return map.map(plan, PlanDto.class);

	}

	@Override
	public boolean updatePlan(Integer planId, PlanCreateDto plancreateDto) {

		log.info("I am inService Layer ::{}", planId);

		PlanMaster updatedPlanmaster = repo.findById(planId)
				.orElseThrow(() -> new planNotFoundException("Plan not found"));

		if (!updatedPlanmaster.getPlanName().equals(plancreateDto.getPlanName())
				&& repo.existsByPlanName(plancreateDto.getPlanName())) {
			throw new DuplicatePlanException("Plan Name Already exist");
		}

		map.map(plancreateDto, updatedPlanmaster);

		updatedPlanmaster.setUpdatedDate(LocalDate.now());

		repo.save(updatedPlanmaster);

		return true;
	}

}
