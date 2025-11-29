package com.pma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.dto.PlanCreateDto;
import com.pma.dto.PlanDto;
import com.pma.service.PlanMasterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/plans")
@Slf4j
@Validated
@Tag(name = "Plan Master", description = "Plan CRUD API")
public class PlanMasterController {

	@Autowired
	private PlanMasterService ps;

	@Operation(summary = "Create a new plan", description = "Creates a new plan using the provided details")
	@PostMapping("/plans")
	public ResponseEntity<String> createPlan(@Valid @RequestBody PlanCreateDto plancreatedto) {

		log.info(" i am in Controller Layer ::{}", plancreatedto);

		boolean saved = ps.savePlan(plancreatedto);

		if (saved) {
			return ResponseEntity.status(201).body("plan created Succesfully");
		} else {
			return ResponseEntity.status(500).body("Failed to create plan");
		}

	}

	@GetMapping
	@Operation(summary = "Get All Plans", description = "Fetch All the plans from database")
	public ResponseEntity<List<PlanDto>> getAllPlans() {

		log.info(" i am in Controller Layer ::{}");

		return ResponseEntity.ok(ps.getPlans());

	}

	@GetMapping("/{planId}")
	@Operation(summary = "Get plan by ID", description = "Returns details of a specific plan using planId")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Plan found"),
			@ApiResponse(responseCode = "404", description = "Plan not found") })
	public ResponseEntity<PlanDto> getPlan(@PathVariable Integer planId) {

		log.info(" i am in Controller Layer ::{}", planId);

		return ResponseEntity.ok(ps.getPlan(planId));

	}

	@PutMapping("/{planId}")
	@Operation(summary = "Update plan", description = "Updates an existing plan using planId")
	public ResponseEntity<String> updatePlan(@PathVariable Integer planId,
			@Valid @RequestBody PlanCreateDto plancreateDto) {

		log.info(" i am in Controller Layer ::{}", planId);

		ps.updatePlan(planId, plancreateDto);

		return ResponseEntity.ok("plan Updated");

	}
}
