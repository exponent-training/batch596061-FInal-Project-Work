package com.c.a.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c.a.a.dto.CitizenDto;
import com.c.a.a.entity.CitizenApplication;
import com.c.a.a.service.CitizenApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/citizen-apps")
@Validated
@Slf4j
public class CitizenApplicationController {
	
	@Autowired
    private CitizenApplicationService cs;

	
	@PostMapping
	@Operation(summary = "Create a new  Citizen Applicationplan", description = "Creates a newcitizen Application plan using the provided details")
    public ResponseEntity<String> createCitizenApplication(@RequestBody @Validated CitizenDto dto) {
        boolean saved = cs.createApplication(dto);
        if (saved) {
            return
            		ResponseEntity.ok("Citizen application submitted successfully");
        }
        return
        		ResponseEntity.badRequest().body("Unable to submit application");
    }

	@GetMapping("/{appNumber}")
	@Operation(summary="Get One Applications",description="get one Citizen Applications")
	public ResponseEntity<?> getApplication(@PathVariable Integer appNumber){
		
		log.info("I am inService layer::{}",appNumber);
		
	
		return  ResponseEntity.ok(cs.getApp(appNumber));
		

	}
	@GetMapping
	@Operation(summary="Get All Applications",description="get All Citizen Applications")
	public ResponseEntity<List<CitizenApplication>> getAllApplications(){
		
		log.info("I am inService layer::{}");
		
		return ResponseEntity.ok(cs.getApps());
		
	}
	@GetMapping("/citizen/{citizenId}")
	@Operation(summary = "Get plan by CitizenID", description = "Returns details of a specific citizenplan using using Id")
	public ResponseEntity<CitizenApplication> getAppByCitizenId(@PathVariable Integer citizenId){
	
		
		log.info("I am inService layer::{}",citizenId);
		
	
		return ResponseEntity.ok(cs.getAppWithCitizenId(citizenId));
		
	}
}
