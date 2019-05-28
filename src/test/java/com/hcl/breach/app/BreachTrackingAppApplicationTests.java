package com.hcl.breach.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;
import com.hcl.breach.app.service.BreachAppServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BreachTrackingAppApplicationTests {
	
	@InjectMocks
	private BreachAppServiceImpl service;
	
	@Mock	
	private BreachRepository repository;
	
	@Test
	public void searchBreachByIdTest(){
		
		  BreachInfo breachInfo=new BreachInfo(11L,"Loan","Loan","Loan","Ram","valid",new Date());		 
		  
		  when(repository.findByBreachId(11L)).thenReturn(breachInfo);
		 
		  BreachInfo info=service.searchBreachById(11L);
	   	 assertEquals(breachInfo.toString(), info.toString());
		 
	}

}
