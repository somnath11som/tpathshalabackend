package com.project.tpathshala.payload;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

public class LeadReportRequest {

	private int id;
	
	@NotNull(message = "Lead ID required")
	private int leadId;
	
	@NotNull(message = "Asign User ID required")
	private int userId;
	
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = new Date();
	}

	public LeadReportRequest(int id, @NotNull(message = "Lead ID required") int leadId,
			@NotNull(message = "Asign User ID required") int userId, String comment, Date createdAt) {
		super();
		this.id = id;
		this.leadId = leadId;
		this.userId = userId;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public LeadReportRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
