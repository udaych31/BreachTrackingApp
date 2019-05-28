package com.hcl.breach.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.service.BreachAppServiceImpl;

@RestController
@RequestMapping("/breach")
public class BreachAppController {
	
private static final Logger logger = LoggerFactory.getLogger(BreachAppController.class);
	
	@Autowired
	private BreachAppServiceImpl service;
	
	@GetMapping("/search/{breachId}")
	public BreachInfo searchBreachById(@PathVariable("breachId") Long breachId) {
		logger.info("******* Entering to searchBreachById() in controller *******");
		return service.searchBreachById(breachId);
	}

}
