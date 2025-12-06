package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.EducationDTO;
import com.DTO.IncomeDTO;
import com.DTO.KidsDTO;
import com.DTO.SummeryDTO;
import com.Service.DataCollectService;

@RestController
@RequestMapping("/dc")
public class DcController {

    @Autowired
    private DataCollectService service;

    @PostMapping("/income/{appId}/{userId}")
    public String saveIncome(@RequestBody IncomeDTO dto,
                             @PathVariable Integer appId,
                             @PathVariable Integer userId) {
        return service.saveIncome(dto,appId,userId)
                ?"Income Saved":"Failed";
    }

    @PostMapping("/education/{appId}/{userId}")
    public String saveEducation(@RequestBody EducationDTO dto,
                                @PathVariable Integer appId,
                                @PathVariable Integer userId) {
        return service.saveEducation(dto,appId,userId)
                ?"Education Saved":"Failed";
    }

    @PostMapping("/kids/{appId}/{userId}")
    public String saveKids(@RequestBody KidsDTO dto,
                           @PathVariable Integer appId,
                           @PathVariable Integer userId) {
        return service.saveKids(dto,appId,userId)
                ?"Kid Saved":"Failed";
    }

    @GetMapping("/summary/{appId}")
    public SummeryDTO getSummary(@PathVariable Integer appId) {
        return service.getSummaryData(appId);
    }
}