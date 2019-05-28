package com.hcl.breach.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;
import com.hcl.breach.app.dto.BreachDto;
import com.hcl.breach.app.entity.BreachInfo;
import com.hcl.breach.app.repository.BreachRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BreachAppServiceImplTest {
	
	private static final Logger logger=LogManager.getLogger(BreachAppServiceImplTest.class);
	
	
	@Mock
	private BreachRepository repository;
	
	@InjectMocks
	private BreachAppServiceImpl service;
	
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
