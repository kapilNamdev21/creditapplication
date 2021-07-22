package com.demo.creditcardapplication.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.creditcardapplication.api.service.ApplicationService;
import com.demo.creditcardapplication.api.dto.ApplicationDto;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/applications")
	public String applyforcreadit(@RequestBody ApplicationDto applicationdto){
		
		return applicationService.applyforcreadit(applicationdto);
	}
	
	@GetMapping("/applications/{applicationNumber}")
	public String getStatus(@PathVariable("applicationNumber") long applicationNumber ) {
		
		return applicationService.getStatus(applicationNumber);
	}

}
