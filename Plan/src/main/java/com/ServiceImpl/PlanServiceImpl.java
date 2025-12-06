package com.ServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.PlanDTO;
import com.Entity.PlanMaster;
import com.Repository.PlanMasterRepository;
import com.Service.PlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMasterRepository repository;

    // Save Plan
    @Override
    public boolean savePlan(PlanDTO dto) {

        PlanMaster entity = new PlanMaster();
        entity.setPlanName(dto.getPlanName());
        entity.setPlanStartDate(dto.getPlanStartDate());
        entity.setPlanEndDate(dto.getPlanEndDate());
        entity.setActiveSw(dto.getActiveSw());
        entity.setComments(dto.getComments());
        entity.setCreatedDate(LocalDate.now());

        repository.save(entity);
        return true;
    }

    // Get All Plans
    @Override
    public List<PlanDTO> getPlans() {

        List<PlanMaster> list = repository.findAll();
        List<PlanDTO> dtoList = new ArrayList<>();

        for (PlanMaster p : list) {
            PlanDTO dto = new PlanDTO();
            dto.setPlanId(p.getPlanId());
            dto.setPlanName(p.getPlanName());
            dto.setPlanStartDate(p.getPlanStartDate());
            dto.setPlanEndDate(p.getPlanEndDate());
            dto.setActiveSw(p.getActiveSw());
            dto.setComments(p.getComments());
            dto.setCreatedDate(p.getCreatedDate());
            dto.setUpdatedDate(p.getUpdatedDate());

            dtoList.add(dto);
        }
        return dtoList;
    }

    // Get Plan by ID
    @Override
    public PlanDTO getPlan(Integer planId) {

        PlanMaster p = repository.findById(planId).orElse(null);

        if (p == null) {
            return null;
        }

        PlanDTO dto = new PlanDTO();
        dto.setPlanId(p.getPlanId());
        dto.setPlanName(p.getPlanName());
        dto.setPlanStartDate(p.getPlanStartDate());
        dto.setPlanEndDate(p.getPlanEndDate());
        dto.setActiveSw(p.getActiveSw());
        dto.setComments(p.getComments());
        dto.setCreatedDate(p.getCreatedDate());
        dto.setUpdatedDate(p.getUpdatedDate());

        return dto;
    }

    // Update Plan
    @Override
    public boolean updatePlan(Integer planId, PlanDTO dto) {

        PlanMaster p = repository.findById(planId).orElse(null);

        if (p == null) {
            return false;
        }

        p.setPlanName(dto.getPlanName());
        p.setPlanStartDate(dto.getPlanStartDate());
        p.setPlanEndDate(dto.getPlanEndDate());
        p.setActiveSw(dto.getActiveSw());
        p.setComments(dto.getComments());
        p.setUpdatedDate(LocalDate.now());

        repository.save(p);
        return true;
    }
}
