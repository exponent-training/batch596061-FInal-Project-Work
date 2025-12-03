package com.AR_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AR_Model.CitizenApplication;
import com.AR_Model.CitizenApplicationDTO;
import com.service.AR_Service;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/ar")
@RestController
@Slf4j
public class HomeController {

	@Autowired
	private AR_Service arservice; 
	
	@PostMapping(value = "/reg")
	public ResponseEntity<?> applicationRaegistration(@RequestBody CitizenApplicationDTO dto) {
		log.info("I am in homecontroller :-"+dto);
		String s;
		boolean b=arservice.applicationRegistration(dto);
		if(b==true) {
			s="Application Saved!!!";
		}else {
			s="application not saved !!!!";
			return ResponseEntity.status(404).body(s);
		}
		
		return ResponseEntity.ok(s);
		
	}
	
	@GetMapping(value = "/getapp")
	public ResponseEntity<?> getapp(@RequestParam int appNum){
		
		log.info("I am in homecontroller :-"+appNum);
		
		CitizenApplication ctapp=arservice.getApp(appNum);
		
		String ms;
			
		if(ctapp == null) {
		String s="application not found !!!!";
			return ResponseEntity.status(404).body(s);
		}
		
		return ResponseEntity.ok(ctapp);
		
	}
	
	
	@GetMapping(value = "/getapps")
	public ResponseEntity<?> getapps(){
		
		log.info("I am in homecontroller ");
		
		List <CitizenApplication> ctapplist=arservice.getApps();
		
		String ms;
			
		if(ctapplist == null) {
		String s="applications not found !!!!";
			return ResponseEntity.status(404).body(s);
		}
		
		return ResponseEntity.ok(ctapplist);
		
	}
}
