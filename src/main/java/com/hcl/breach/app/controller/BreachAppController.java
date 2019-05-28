package com.hcl.breach.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.dto.ListBreachResponse;
import com.hcl.breach.app.service.BreachAppService;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.service.BreachAppServiceImpl;
import com.hcl.breach.app.repository.BreachResponse;
import com.hcl.breach.app.service.BreachAppService;
import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;

@RestController
@RequestMapping("/breach")
public class BreachAppController {
	private static final Logger logger = LogManager.getLogger(BreachAppController.class);

	@Autowired
	BreachAppService breachAppService;
	
	@GetMapping("/listbreach")
	public ListBreachResponse listbreach()
	{
		logger.info("inside in controller");
		logger.debug("inside########");

		ListBreachResponse listBreachResponse=breachAppService.listbreach();
		return listBreachResponse;
		
	}

	
	@GetMapping("/search/{breachId}")
	public BreachInfo searchBreachById(@PathVariable("breachId") Long breachId) {
		logger.info("******* Entering to searchBreachById() in controller *******");
		return breachAppService.searchBreachById(breachId);

	}
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
