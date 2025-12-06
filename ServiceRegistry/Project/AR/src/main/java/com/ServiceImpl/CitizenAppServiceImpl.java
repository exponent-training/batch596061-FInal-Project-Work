package com.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DTO.CitizenApplicationRequestDTO;
import com.DTO.CitizenApplicationResponseDTO;
import com.Entity.CitizenApplication;
import com.Entity.PlanMaster;
import com.Entity.User;
import com.Repository.CitizenApplicationRepository;
import com.Repository.PlanMasterRepository;
import com.Repository.UserRepository;
import com.Service.CitizenApplicationService;

@Service
public class CitizenAppServiceImpl implements CitizenApplicationService {

    @Autowired private CitizenApplicationRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private PlanMasterRepository planRepo;

    @Override
    public boolean createApplication(CitizenApplicationRequestDTO dto) {

        if(repo.existsBySsn(dto.getSsn()))
            throw new RuntimeException("SSN already exists!");

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PlanMaster plan = planRepo.findById(dto.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan with ID " + dto.getPlanId() + " not found"));

        CitizenApplication app = new CitizenApplication();
        app.setFullname(dto.getFullname());
        app.setDob(dto.getDob());
        app.setGender(dto.getGender());
        app.setSsn(dto.getSsn());
        app.setUser(user);
        app.setPlan(plan);
        app.setCreatedDate(LocalDate.now());

        repo.save(app);
        return true;
    }

    @Override
    public CitizenApplicationResponseDTO getApp(Integer id) {
        return convert(repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application Not Found")));
    }

    @Override
    public List<CitizenApplicationResponseDTO> getApps() {
        return repo.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public CitizenApplicationResponseDTO getAppWithCitizenId(Integer ssn) {
        return convert(repo.findBySsn(Long.valueOf(ssn))
                .orElseThrow(() -> new RuntimeException("Not Found")));
    }

    private CitizenApplicationResponseDTO convert(CitizenApplication a) {
        return new CitizenApplicationResponseDTO(
                a.getAppNumber(), a.getFullname(), a.getDob(), a.getGender(), a.getSsn(),
                a.getPlan().getPlanName(), a.getUser().getEmail(), a.getCreatedDate()
        );
    }
}
