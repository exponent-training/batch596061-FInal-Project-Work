package com.IES.CM.Services;

import java.util.List;

import com.Entity.CitizenApplication;
import com.IES.CM.Dto.citizenDto;

public interface citizenArService {

	 boolean createApplication(citizenDto cDto);

	 CitizenApplication getApplication(Integer appNum);

	List<CitizenApplication> getAllApplication();

	CitizenApplication getAppWithCitizenId(Integer citizenId);

}
