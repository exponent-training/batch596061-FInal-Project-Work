package com.Service;

import java.util.List;

import com.DTO.CitizenApplicationRequestDTO;
import com.DTO.CitizenApplicationResponseDTO;

// CitizenApplicationService
public interface CitizenApplicationService {

    boolean createApplication(CitizenApplicationRequestDTO dto);

    CitizenApplicationResponseDTO getApp(Integer appNum);

    List<CitizenApplicationResponseDTO> getApps();

    CitizenApplicationResponseDTO getAppWithCitizenId(Integer citizenId);
}
