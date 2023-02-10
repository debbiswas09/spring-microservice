package com.deb.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deb.microservices.limitsservice.bean.Limits;
import com.deb.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public Limits retiriveLimits() {
		
		return new Limits(config.getMinimum(),config.getMaximum());
		
		//return new Limits(1,1000);
		
	}
	
	

}
