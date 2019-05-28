package com.hcl.breach.app.dto;

import java.io.Serializable;
import java.util.Date;

public class BreachDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long breachId;
	
	private String breachName;
	
	private String breachType;
	
	private String breachDesc;
	
	private String createByUser;
	
	private String status;
	
	private Date createDt;
	
	public BreachDto() {
		super();
	}

	public Long getBreachId() {
		return breachId;
	}

	public void setBreachId(Long breachId) {
		this.breachId = breachId;
	}

	public String getBreachName() {
		return breachName;
	}

	public void setBreachName(String breachName) {
		this.breachName = breachName;
	}

	public String getBreachType() {
		return breachType;
	}

	public void setBreachType(String breachType) {
		this.breachType = breachType;
	}

	public String getBreachDesc() {
		return breachDesc;
	}

	public void setBreachDesc(String breachDesc) {
		this.breachDesc = breachDesc;
	}

	public String getCreateByUser() {
		return createByUser;
	}

	public void setCreateByUser(String createByUser) {
		this.createByUser = createByUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BreachDto [breachId=");
		builder.append(breachId);
		builder.append(", breachName=");
		builder.append(breachName);
		builder.append(", breachType=");
		builder.append(breachType);
		builder.append(", breachDesc=");
		builder.append(breachDesc);
		builder.append(", createByUser=");
		builder.append(createByUser);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append("]");
		return builder.toString();
	}
	
}
