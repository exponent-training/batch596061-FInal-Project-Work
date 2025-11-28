package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.PlanMaster;
import com.Model.PlansDto;
import com.Service.PlanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/plan")
@Slf4j
public class HomeController {
  
	@Autowired
	private PlanService planser; 
	  
	@PostMapping(value = "/save")
	  public boolean savePlan(@RequestBody PlansDto pDto) {
		boolean b=planser.savePlan(pDto);
		if (b==true) {
			log.info("Plan Saved!!!");
		} else {
            log.info("Plan Not Saved!!");
		}
		  return b;
		  
	  }
	
	@GetMapping(value="/getplans")
	public List<PlanMaster> getPlans(){
		
		List<PlanMaster> planmaster=(List<PlanMaster>) planser.getplans();
		return planmaster;
		
		
	}
	
	@GetMapping(value = "/getplan")
	public ResponseEntity<?> getplan(@RequestParam int pid){

		PlanMaster pm=planser.getplan(pid);
		
		if (pm==null) {
			log.info("Plan Not Present !!!!");
			  return ResponseEntity.status(404).body("Plan Not Found");
		}
		return  ResponseEntity.ok(pm);
		}
	
	@PutMapping(value="/update")
	public ResponseEntity<?> updatePlan(@RequestParam String status,int pid) {
		PlanMaster pm=planser.updatePlan(status,pid);
		
		if (pm==null) {
			log.info("Plan Not Found !!!!");
			  return ResponseEntity.status(404).body("Plan Not Found");
		}
		return  ResponseEntity.ok("Plan Updated!!");
	}
	
	@DeleteMapping(value = "/delete")
	public String deletePlan(@RequestParam int pid) {
		String s=planser.deletePlan(pid);
		
		if(s==null) {
			return "Plan Not Present!!";
		}
			return "Plan Deleted Successfully!!!";
		}
	}
	

