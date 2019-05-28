package com.hcl.breach.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;
import com.hcl.breach.app.service.BreachAppServiceImpl;

@RestController
@RequestMapping("/breach")
public class BreachAppController {
	
	@Autowired
	private BreachAppServiceImpl serviceImpl;
	
	
	@PostMapping("/createbreach")
	public BreachCreateResponse createBreach(@RequestBody BreachCreateRequest request) {
		return serviceImpl.createBreach(request);
	}
	

}
