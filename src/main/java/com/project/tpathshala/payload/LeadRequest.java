package com.project.tpathshala.payload;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;


public class LeadRequest {

	private int id;
	
	private String name;
	
	private String email;
	
	@Size(min = 10, max = 10, message = "Minimum and Maxmimum 10 digit phone number required")
	private String phone;
	
	private String course_name;
	
	private String lead_status;
	
	private String qualification;
	
	private String lead_comes_from;
	
	private String time_slot;
	
	private String lead_comments;
	
	private int assign_user_id;
	
	private int assign_by;
	
	private int assign_on;
	
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getLead_status() {
		return lead_status;
	}

	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLead_comes_from() {
		return lead_comes_from;
	}

	public void setLead_comes_from(String lead_comes_from) {
		this.lead_comes_from = lead_comes_from;
	}

	public String getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

	public String getLead_comments() {
		return lead_comments;
	}

	public void setLead_comments(String lead_comments) {
		this.lead_comments = lead_comments;
	}

	public int getAssign_user_id() {
		return assign_user_id;
	}

	public void setAssign_user_id(int assign_user_id) {
		this.assign_user_id = assign_user_id;
	}

	public int getAssign_by() {
		return assign_by;
	}

	public void setAssign_by(int assign_by) {
		this.assign_by = assign_by;
	}

	public int getAssign_on() {
		return assign_on;
	}

	public void setAssign_on(int assign_on) {
		this.assign_on = assign_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public LeadRequest(int id, String name, String email, String phone, String course_name, String lead_status,
			String qualification, String lead_comes_from, String time_slot, String lead_comments, int assign_user_id,
			int assign_by, int assign_on, String status, Date created_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.course_name = course_name;
		this.lead_status = lead_status;
		this.qualification = qualification;
		this.lead_comes_from = lead_comes_from;
		this.time_slot = time_slot;
		this.lead_comments = lead_comments;
		this.assign_user_id = assign_user_id;
		this.assign_by = assign_by;
		this.assign_on = assign_on;
		this.status = status;
		this.created_at = created_at;
	}

	public LeadRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
