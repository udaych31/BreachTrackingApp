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

@Service
public class BreachAppServiceImpl implements BreachAppService {

	@Autowired
	BreachRepository breachRepository;

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

}
