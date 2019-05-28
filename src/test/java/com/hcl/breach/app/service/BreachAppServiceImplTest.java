package com.hcl.breach.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.app.dto.BreachInfoDto;
import com.hcl.breach.app.dto.ListBreachResponse;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;

@RunWith(MockitoJUnitRunner.class)

public class BreachAppServiceImplTest {
	@Mock
	BreachRepository repository;

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

}
