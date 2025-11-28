package com.planServiceImpl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.PlansDto;
import com.Entity.PlanMaster;
import com.PlanRepo.PlanRepository;
import com.planService.PlanServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlanServicesImpl implements PlanServices {
	
	@Autowired
	private PlanRepository pr;

	@Override
	public boolean savePlan(PlansDto plandto) {
		
		ModelMapper model = new ModelMapper();
		log.info("planServices dto ::"+ plandto);
		
		PlanMaster pm =new PlanMaster();
		PlanMaster planmaster= model.map(plandto,PlanMaster.class);
		log.info("planMaster ::"+planmaster);
		
		PlanMaster planMaster2=pr.save(planmaster);
		return planMaster2.getPlanId()!=null;
	}

	

	@Override
	public List<PlansDto> getPlans() {
		List<PlanMaster> li=pr.findAll();
		
		ModelMapper model =new ModelMapper();
		List<PlansDto> listdto= li.stream().map(plan ->model.map(plan,PlansDto.class)).collect(Collectors.toList());
		log.info("list of plans"+listdto);
		return listdto;
	}



	@Override
	public PlansDto getplan(int id) {
		ModelMapper model =new ModelMapper(); 
		/*
		 * Optional<PlanMaster> plan = pr.findById(id); PlansDto pm = model.map(plan,PlansDto.class);
		 */
		 PlanMaster plan = pr.findById(id)
		            .orElseThrow(() -> new RuntimeException("Plan not found"));

		    return model.map(plan, PlansDto.class);
		
	
	}



	@Override
	public boolean updatePlan(Integer id, PlansDto dto) {
		Optional<PlanMaster> optional = pr.findById(id);
		ModelMapper model=new ModelMapper();
	    if (!optional.isPresent()) {
	        return false;
	    }

	    PlanMaster plan = optional.get();

	    if (dto.getPlanName() != null) {
	        plan.setPlanName(dto.getPlanName());
	    }
	    if (dto.getActiveSw() != null) {
	        plan.setActiveSw(dto.getActiveSw());
	    }
	    if (dto.getPlanStartDate() != null) {
	        plan.setPlanStartDate(dto.getPlanStartDate());
	    }
	    if (dto.getPlanEndDate() != null) {
	        plan.setPlanEndDate(dto.getPlanEndDate());
	    }
	    if(dto.getComments() !=null) {
	    	plan.setComments(dto.getComments());
	    }

	    PlanMaster updated = pr.save(plan);

	     
	     return true;
	}

}
