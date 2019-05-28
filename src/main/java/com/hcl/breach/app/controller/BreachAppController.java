package com.hcl.breach.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.repository.BreachResponse;
import com.hcl.breach.app.service.BreachAppService;
import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;

@RestController
@RequestMapping("/breach")
public class BreachAppController {

	@Autowired
	BreachAppService breachAppService;

	@PostMapping("/createbreach")
	public BreachCreateResponse createBreach(@RequestBody BreachCreateRequest request) {
		return breachAppService.createBreach(request);
	}

	@PutMapping("/breachConfirmation")
	public BreachResponse breachConfirmation(@RequestParam Long id, @RequestParam String status) {

		BreachResponse response = breachAppService.breachConfirmation(status, id);

		return response;

	}

}
