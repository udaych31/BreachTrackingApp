package com.hcl.breach.app.dto;

import java.io.Serializable;

import com.hcl.breach.app.util.Response;

public class BreachCreateResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BreachDto response;
	
	public BreachCreateResponse() {
		super();
	}

	public BreachDto getResponse() {
		return response;
	}

	public void setResponse(BreachDto response) {
		this.response = response;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BreachCreateResponse [response=");
		builder.append(response);
		builder.append("]");
		return builder.toString();
	}
	

}
