package com.project.tpathshala.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="lead_report")
public class LeadReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lead_report_id")
	private int id;
	
	@Column(name="lead_id")
	private int leadId;
	
	@Column(name = "assign_user_id")
	private int userId;
	
	@Column(name = "lead_comments")
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

	public LeadReport(int id, int leadId, int userId, String comment, Date createdAt) {
		super();
		this.id = id;
		this.leadId = leadId;
		this.userId = userId;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public LeadReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
