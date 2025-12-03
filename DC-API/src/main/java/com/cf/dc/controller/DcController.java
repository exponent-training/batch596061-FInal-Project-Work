package com.cf.dc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.dc.dto.CitizenDto;
import com.cf.dc.dto.EducationDto;
import com.cf.dc.dto.IncomeDto;
import com.cf.dc.dto.KidDto;
import com.cf.dc.dto.SummaryResponseDto;
import com.cf.dc.service.DcService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/cf/dc")
public class DcController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/saveIncome/{appno}")
	public ResponseEntity<?> saveIncome(@Valid @RequestBody IncomeDto income , @PathVariable Integer appno){
	
	log.info("DC Controller : "+ income);
	boolean res = dcService.saveIncome(income, appno);
	if(res) {
		return new ResponseEntity("Income Details Saved " , HttpStatus.OK);
		
	}else {
		return new ResponseEntity("Income Details Not Saved" , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/saveEducation/{appNo}")
	public ResponseEntity<?> saveEducation(@Valid @RequestBody EducationDto edu,@PathVariable Integer appNo ,@RequestParam Integer userId ){
		
		log.info("DC Edu Controller " +edu);
		
		boolean res = dcService.saveEducation(edu, appNo, userId);
		
		if(res) {
			return new ResponseEntity("Education Details Saved " , HttpStatus.OK);
			
		}else {
			return new ResponseEntity("Education Details Not Saved" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	} 
	
	
	@PostMapping("/saveKid/{appNo}")
	public ResponseEntity<?> saveKids(@Valid @RequestBody KidDto kid ,@PathVariable Integer appNo , @RequestParam Integer userId ){
		log.info("DC Kids Controller " + kid);
		
		boolean res = dcService.saveKid(kid, appNo, userId);
		
		if(res) {
			return new ResponseEntity("Kids Details Saved " , HttpStatus.OK);
			
		}else {
			return new ResponseEntity("Kid Details Not Saved" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @Operation(description = "Get Summary Data", summary = "Returns education, income, and kids summary for given application number")
	@GetMapping("/summary/{appNo}")
	public ResponseEntity<?> getSummary(@PathVariable Integer appNo) {

	    log.info("DC Summary Controller, AppNo: " + appNo);

	    SummaryResponseDto response = dcService.getSummaryData(appNo);

	    return ResponseEntity.ok(response);
	}
}
