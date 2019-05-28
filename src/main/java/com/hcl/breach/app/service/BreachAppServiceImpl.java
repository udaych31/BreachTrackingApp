package com.hcl.breach.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.app.dto.BreachInfoDto;
import com.hcl.breach.app.dto.ListBreachResponse;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;
import java.util.Optional;
import com.hcl.breach.app.repository.BreachResponse;

import java.util.Date;

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
				
				BreachInfo breach = breachInfo.get();
				if(breach!=null) {
					
					if(status.equalsIgnoreCase("accept")) {
						breach.setStatus("ACCEPTED");
						breachRepository.save(breach);
						response.setMessage("The breach has been Accepted");
					}else if(status.equalsIgnoreCase("reject")) {
						breach.setStatus("REJECTED");
						breachRepository.save(breach);
						response.setMessage("The breach has been Rejected");
					}else {
						breach.setStatus("PENDING");
						breachRepository.save(breach);
						response.setMessage("The breach has been still Pending ...!");
					}
				}
				
			} else {
				response.setMessage("The record was not found");
			}

		} catch (Exception e) {
			logger.error((this.getClass().getName()) + "Not updated the record" + e.getMessage());

		}

		return response;

	}

	@Override
	public ListBreachResponse listbreach() {
		ListBreachResponse listBreachResponse = new ListBreachResponse();
		Logger log = LogManager.getLogger(BreachAppServiceImpl.class);
		try {
			List<BreachInfo> breachInfoList = breachRepository.findAll();
				
			ArrayList<BreachInfoDto> breachInfoListDto = new ArrayList<BreachInfoDto>();
			for (BreachInfo breachInfo : breachInfoList) {
				BreachInfoDto BreachInfoDtoObj = new BreachInfoDto();
				BreachInfoDtoObj.setBreachId(breachInfo.getBreachId());
				BreachInfoDtoObj.setBreachName(breachInfo.getBreachName());
				BreachInfoDtoObj.setBreachType(breachInfo.getBreachType());
				BreachInfoDtoObj.setCreateByUser(breachInfo.getCreateByUser());
				BreachInfoDtoObj.setCreateDt(breachInfo.getCreateDt());
				BreachInfoDtoObj.setStatus(breachInfo.getStatus());
				BreachInfoDtoObj.setBreachDesc(breachInfo.getBreachDesc());
				breachInfoListDto.add(BreachInfoDtoObj);

			}
			listBreachResponse.setBreachInfoDto(breachInfoListDto);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return listBreachResponse;
	}

	
	
	public BreachInfo searchBreachById(Long breachId) {
		logger.info("******* Entering to searchBreachById() in service *******");
		return breachRepository.findByBreachId(breachId);
		}
}
