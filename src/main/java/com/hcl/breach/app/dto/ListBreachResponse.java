package com.hcl.breach.app.dto;

import java.util.List;

public class ListBreachResponse {

	private List<BreachInfoDto> breachInfoDto;

	public List<BreachInfoDto> getBreachInfoDto() {
		return breachInfoDto;
	}

	public void setBreachInfoDto(List<BreachInfoDto> breachInfoDto) {
		this.breachInfoDto = breachInfoDto;
	}

	@Override
	public String toString() {
		return breachInfoDto.size()+"";
	}
	
	
}
