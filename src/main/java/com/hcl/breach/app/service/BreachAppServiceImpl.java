package com.hcl.breach.app.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;
import com.hcl.breach.app.repository.BreachResponse;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;
import com.hcl.breach.app.dto.BreachDto;

@Service
public class BreachAppServiceImpl implements BreachAppService {
	
	private static final Logger logger=LogManager.getLogger(BreachAppServiceImpl.class);
	
	@Autowired
	private BreachRepository breachRepository;

	@Override
	public BreachCreateResponse createBreach(BreachCreateRequest request) {
		BreachCreateResponse response=new BreachCreateResponse();
		try {
			if(request!=null) {
				BreachInfo breach=new BreachInfo();
				breach.setBreachName(request.getName());
				breach.setBreachType(request.getType());
				breach.setBreachDesc(request.getDescription());
				breach.setCreateByUser(request.getCreatedByUser());
				breach.setStatus("PENDING");
				breach.setCreateDt(new Date());
				BreachInfo res = breachRepository.save(breach);
				logger.debug(res.toString());
				response.setMessage("Breach created successfully...!");
				response.setStatusCode(201);
				BreachDto dto=new BreachDto();
				dto.setBreachId(res.getBreachId());
				dto.setBreachDesc(res.getBreachDesc());
				dto.setBreachName(res.getBreachName());
				dto.setBreachType(res.getBreachType());
				dto.setCreateByUser(res.getCreateByUser());
				dto.setCreateDt(res.getCreateDt());
				dto.setStatus(res.getStatus());
				logger.debug(dto.toString());
				response.setResponse(dto);
			}
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" createBreach :"+e.getMessage());
		}
		return response;
	}


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
