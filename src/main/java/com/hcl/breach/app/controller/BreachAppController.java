package com.hcl.breach.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.app.dto.ListBreachResponse;
import com.hcl.breach.app.service.BreachAppService;

@RestController
@RequestMapping("/breach")
public class BreachAppController {
	
	@Autowired
	BreachAppService breachAppService;
	
	@GetMapping("/listbreach")
	public ListBreachResponse listbreach()
	{
		final Logger logger=LogManager.getLogger(BreachAppController.class);
		logger.info("inside in controller");
		logger.debug("inside########");

		ListBreachResponse listBreachResponse=breachAppService.listbreach();
		return listBreachResponse;
		
	}
	

}
