package com.hcl.breach.app.service;

import com.hcl.breach.app.repository.BreachResponse;

public interface BreachAppService {

	BreachResponse breachConfirmation(String status,Long id);

}
