package com.hcl.breach.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;
import com.hcl.breach.app.dto.BreachDto;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;

import com.hcl.breach.app.dto.BreachInfoDto;
import com.hcl.breach.app.dto.ListBreachResponse;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;

@RunWith(MockitoJUnitRunner.class)

public class BreachAppServiceImplTest {
	@Mock
	BreachRepository repository;
	
	private static final Logger logger=LogManager.getLogger(BreachAppServiceImplTest.class);
	
	@InjectMocks
	private BreachAppServiceImpl service;
	@InjectMocks
	BreachAppServiceImpl serviceImpl;

	@Test
	public void listbreach() {

		BreachInfo breachInfo = new BreachInfo();
		breachInfo.setBreachId(1l);
		breachInfo.setBreachName("security");
		breachInfo.setBreachType("saving");
		breachInfo.setCreateByUser("khan");
		Date dt = new Date();
		breachInfo.setCreateDt(dt);
		breachInfo.setStatus("pending");
		breachInfo.setBreachDesc("ma");
		List<BreachInfo> list = new ArrayList<BreachInfo>();
		list.add(breachInfo);
		Mockito.when(repository.findAll()).thenReturn(list);
		BreachInfoDto breachInfoDto = new BreachInfoDto();
		breachInfoDto.setBreachId(1l);
		breachInfoDto.setBreachName("security");
		breachInfoDto.setBreachType("saving");
		breachInfoDto.setCreateByUser("khan");
		breachInfoDto.setCreateDt(dt);
		breachInfoDto.setStatus("pending");
		breachInfoDto.setBreachDesc("ma");
		List<BreachInfoDto> breachInfoDtoList=new ArrayList<BreachInfoDto>();
		breachInfoDtoList.add(breachInfoDto);
		ListBreachResponse listBreachResponse=new ListBreachResponse();
		listBreachResponse.setBreachInfoDto(breachInfoDtoList);
		ListBreachResponse breachInfoDtoList1=serviceImpl.listbreach();
		 Assert.assertEquals(breachInfoDtoList1.toString(),listBreachResponse.toString());
			
			

	}
	@Test
	public void createBreachTest() {
		try {
				BreachCreateRequest request=new BreachCreateRequest();
				request.setCreatedByUser("uday");
				request.setDescription("personal loan details");
				request.setName("personal loan issue");
				request.setType("loan");
			
				BreachInfo breach=new BreachInfo();
				breach.setBreachName(request.getName());
				breach.setBreachType(request.getType());
				breach.setBreachDesc(request.getDescription());
				breach.setCreateByUser(request.getCreatedByUser());
				breach.setStatus("PENDING");
				breach.setCreateDt(new Date());
				breach.setBreachId(2L);
				
				when(repository.save(breach)).thenReturn(breach);
				BreachDto dto=new BreachDto();
				dto.setBreachId(breach.getBreachId());
				
				BreachCreateResponse res = service.createBreach(request);
				if(res!=null) {
					Integer statusCode = res.getStatusCode();
					Long code=Long.valueOf(""+statusCode);
					Assert.assertEquals(201.0, code);
				}
				
				
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" createBreach :"+e.getMessage());
		}
		
	}
	
	

}
