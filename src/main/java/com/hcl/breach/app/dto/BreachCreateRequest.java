package com.hcl.breach.app.dto;

import java.io.Serializable;

public class BreachCreateRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String type;
	
	private String description;
	
	private String createdByUser;
	
	public BreachCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BreachCreateRequest [name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdByUser=");
		builder.append(createdByUser);
		builder.append("]");
		return builder.toString();
	}

	
}
