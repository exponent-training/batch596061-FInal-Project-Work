package com.ServiceImpl;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.PlanDto;
import com.Entity.Plan;
import com.Repository.PlanRepository;
import com.Service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepo;

    @Override
    public boolean savePlan(PlanDto dto) {

        Plan p = new Plan();
        p.setPlanName(dto.getPlanName());
        p.setPlanStatus(dto.getPlanStatus());

        planRepo.save(p);

        return true;
    }

    @Override
    public List getPlans() {

        List<Plan> list = planRepo.findAll();

        return list.stream().map(p -> {
            PlanDto dto = new PlanDto();
            dto.setPlanId(p.getPlanId());
            dto.setPlanName(p.getPlanName());
            dto.setPlanStatus(p.getPlanStatus());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public PlanDto getPlan(Integer planId) {

        Plan p = planRepo.findById(planId).orElse(null);

        if (p == null) return null;

        PlanDto dto = new PlanDto();
        dto.setPlanId(p.getPlanId());
        dto.setPlanName(p.getPlanName());
        dto.setPlanStatus(p.getPlanStatus());

        return dto;
    }

    @Override
    public boolean updatePlan(Integer planId, String status) {

        Plan p = planRepo.findById(planId).orElse(null);
        if (p == null) return false;

        p.setPlanStatus(status);

        planRepo.save(p);

        return true;
    }
}
