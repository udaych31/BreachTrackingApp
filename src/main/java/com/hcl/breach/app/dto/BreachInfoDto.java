package com.hcl.breach.app.dto;

import java.util.Date;

public class BreachInfoDto {

	private Long breachId;

	private String breachName;

	private String breachType;

	private String breachDesc;

	private String createByUser;

	private String status;

	private Date createDt;

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
	
	

}
