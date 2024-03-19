package com.project.tpathshala.payload;

public class AuthResponse {

	private String email;
	private String name;
	private String phone;
	private String role;
	private String accesstoken;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	public AuthResponse(String email, String name, String phone, String role, String accesstoken) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.accesstoken = accesstoken;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
