package com.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Enum.PlanAc;
import com.Model.PlanMaster;
import com.Model.PlansDto;
import com.Repository.PlanRepo;
import com.Service.PlanService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlanImpl implements PlanService{

	
	@Autowired
	private PlanRepo PRepo;
	
	@Override
	public boolean savePlan(PlansDto pDto) {
		
		PlanMaster pm=new PlanMaster();
		
		pm.setPlanName(pDto.getPlanName());
		pm.setComments(pDto.getComments());
		pm.setActiveSw(PlanAc.ACTIVE);
		pm.setPlanStartDate(LocalDate.now());
		pm.setPlanEndDate(LocalDate.now().plusYears(5));
		
		PRepo.save(pm);
		log.info("Plan Added Successfully!!!!!!!!");
		
		return true;
	}

	@Override
	public List<PlanMaster> getplans() {
		List<PlanMaster> listofplans=(List<PlanMaster>) PRepo.findAll();
		log.info("Plans Diplay Successfully!!!!!");
		return listofplans;
		
	}

	@Override
	public PlanMaster getplan(int pid) {
		
	  PlanMaster pm=PRepo.findById(pid).orElse(null);
	  
	  if(pm==null) {
		  log.info("Plan Not Found!!");
	  }
	  return pm;
		
	}

	@Override
	public PlanMaster updatePlan(String status, int pid) {
		   PlanMaster pm=PRepo.findById(pid).orElse(null);
		   
		   if(pm==null) {
		    	 log.info("Plan Not Found!!"); 
		    	 return null;
		      }
		   
		      if(status.equalsIgnoreCase("y")) {
		    	  pm.setActiveSw(PlanAc.ACTIVE);
		    	  PRepo.save(pm);
		      }
		      if (status.equalsIgnoreCase("n")) {
		    	  pm.setActiveSw(PlanAc.INACTIVE);
		    	  PRepo.save(pm);
			}
		      return pm;
	}

	@Override
	public String deletePlan(int pid) {
		
		PlanMaster pm=PRepo.findById(pid).orElse(null);
		
		if(pm==null) {
			log.info("Plan Not Found!!");
			return null;
		}
		PRepo.deleteById(pid);
		return "Plan Deleted Successfully!!!!";
	}
	
	

}
