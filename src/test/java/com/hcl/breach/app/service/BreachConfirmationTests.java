package com.hcl.breach.app.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;
import com.hcl.breach.app.repository.BreachResponse;
import com.hcl.breach.app.service.BreachAppServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class BreachConfirmationTests {
	

	final Logger logger=LoggerFactory.getLogger(BreachConfirmationTests.class);
	
	
	@Mock
	BreachRepository breachRepository;
	
	@InjectMocks
	BreachAppServiceImpl serviceImpl;
	
	
	@Test
	public void testBreachConfirmation() {
		try {
		
		Optional<BreachInfo> breachs=Optional.empty();
		
		BreachInfo info=new BreachInfo();
		info.setStatus("ACCEPTED");
		
		breachs=Optional.of(info);
		
		String s="accept";
		Long id=1L;
		
		Mockito.when(breachRepository.findById(id)).thenReturn(breachs);

		BreachResponse response=serviceImpl.breachConfirmation(s, id);
		
		Assert.assertEquals("The breach has been Accepted", response.getMessage());
		
	}
	
	catch(Exception e) {
		
		logger.error((this.getClass().getName()) +e.getMessage());

	}

}
}
