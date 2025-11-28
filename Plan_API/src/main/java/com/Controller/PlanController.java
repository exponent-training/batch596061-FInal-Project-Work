package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dto.PlanDto;
import com.Service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController
{
	@Autowired
    private PlanService planService;

    @PostMapping("/save")
    public ResponseEntity<?> savePlan(@RequestBody PlanDto planDto) {
        return ResponseEntity.ok(planService.savePlan(planDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(planService.getPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseEntity.ok(planService.getPlan(id));
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @PathVariable String status) {

        return ResponseEntity.ok(planService.updatePlan(id, status));
    }

}
