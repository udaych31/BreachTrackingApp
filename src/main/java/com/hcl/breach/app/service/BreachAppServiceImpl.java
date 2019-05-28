package com.hcl.breach.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;

@Service
public class BreachAppServiceImpl implements BreachAppService {

private static final Logger logger = LoggerFactory.getLogger(BreachAppServiceImpl.class);

	
	@Autowired
	private BreachRepository repository;
	
	public BreachInfo searchBreachById(Long breachId) {
		logger.info("******* Entering to searchBreachById() in service *******");
		return repository.findByBreachId(breachId);
		}
}
