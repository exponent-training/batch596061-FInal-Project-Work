package com.AR_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AR_Model.CitizenApplicationDTO;
import com.service.AR_Service;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/ar")
@RestController
@Slf4j
public class HomeController {

	@Autowired
	private AR_Service ars; 
	
	@PostMapping(value = "/reg")
	public boolean applicationRaegistration(@RequestBody CitizenApplicationDTO dto) {
		log.info("I am in homecontroller :-"+dto);
		
		ars.applicationRegistration(dto);
		
		return true;
		
	}
}
