package com.hcl.breach.app.service;

import com.hcl.breach.app.dto.BreachCreateRequest;
import com.hcl.breach.app.dto.BreachCreateResponse;

public interface BreachAppService {
	
	public BreachCreateResponse createBreach(BreachCreateRequest request);

}
