package com.hcl.breach.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BREACH_INFO")
@NamedQuery(name="BreachInfo.updateBreachStatus",query="update BreachInfo e set e.status=:status where e.breachId=:breachId")
public class BreachInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long breachId;
	
	@Column
	private String breachName;
	
	@Column
	private String breachType;
	
	@Column
	private String breachDesc;
	
	@Column
	private String createByUser;
	
	@Column
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATETIME")
	private Date createDt;
	
	public BreachInfo() {
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
		builder.append("BreachInfo [breachId=");
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
