package com.hcl.breach.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.repository.BreachResponse;
import com.hcl.breach.app.service.BreachAppService;

@RestController
@RequestMapping("/breach")
public class BreachAppController {
	
	
	@Autowired
	BreachAppService  breachAppService;
	  
	
	@PutMapping("/breachConfirmation")
	public BreachResponse breachConfirmation(@RequestParam Long id,@RequestParam String status) {
		
		BreachResponse response=breachAppService.breachConfirmation(status,id);
		
		return response;
		
		
		
		
	}
	
	

}
