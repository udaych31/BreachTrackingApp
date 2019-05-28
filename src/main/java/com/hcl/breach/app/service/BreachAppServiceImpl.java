package com.hcl.breach.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;
import com.hcl.breach.app.repository.BreachResponse;

@Service
public class BreachAppServiceImpl implements BreachAppService {

	@Autowired
	BreachRepository breachRepository;

	private static final Logger logger = LoggerFactory.getLogger(BreachAppServiceImpl.class);

	@Override
	public BreachResponse breachConfirmation(String status, Long id) {

		BreachResponse response = null;

		try {
			response = new BreachResponse();
			logger.info("enter breachConfiramtion method");

			Optional<BreachInfo> breachInfo = breachRepository.findById(id);

			if (breachInfo.isPresent()) {
				if (breachInfo.get().getStatus().equals("Accepted")) {
					response.setMessage("The breach has been already Accepted");
				}

				else {

					breachRepository.updateBreachStatus(status, id);
					logger.info("updated Successfully");
					response.setMessage("The breach has been Accepted");

				}

			} else {
				response.setMessage("The record was not found");
			}

		} catch (Exception e) {
			logger.error((this.getClass().getName()) + "Not updated the record" + e.getMessage());

		}

		return response;

	}

}
