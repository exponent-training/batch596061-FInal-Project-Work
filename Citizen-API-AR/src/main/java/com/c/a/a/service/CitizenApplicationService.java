package com.c.a.a.service;

import java.util.List;

import com.c.a.a.dto.CitizenDto;
import com.c.a.a.entity.CitizenApplication;

public interface CitizenApplicationService {

	boolean createApplication(CitizenDto citizenDto);

    CitizenApplication getApp(Integer appNumber);

    List<CitizenApplication> getApps();

    CitizenApplication getAppWithCitizenId(Integer citizenId);
}
