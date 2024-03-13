package com.project.tpathshala.payload;

import java.util.HashSet;
import java.util.Set;

import com.project.tpathshala.model.Role;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UserCreateRequest {

	private int id;
	@NotEmpty
	@Size(min = 4, message = "Name must be minimum of 4 character")
	private String name;
	@Email(message = "Email Address is not Valid ||")
	private String email;
    
    @NotEmpty(message = "Give Password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$", message ="Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;
    
    @Size(min = 10, max = 10, message = "Minimum and Maxmimum 10 digit phone number required")
    private String phone;
    
    private String role;
    
    private int role_master_id;
    
    @NotNull(message = "Created By required")
	private int createdBy;

    @NotNull(message = "Modified By required")
	private int modifiedBy;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getRole_master_id() {
		return role_master_id;
	}

	public void setRole_master_id(int role_master_id) {
		this.role_master_id = role_master_id;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	

	public UserCreateRequest(int id,
			@NotEmpty @Size(min = 4, message = "Name must be minimum of 4 character") String name,
			@Email(message = "Email Address is not Valid ||") String email,
			@NotEmpty(message = "Give Password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$", message = "Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character") String password,
			@Size(min = 10, max = 10, message = "Minimum and Maxmimum 10 digit phone number required") String phone,
			String role, int role_master_id, @NotEmpty(message = "Created By required") int createdBy,
			@NotEmpty(message = "Modified By required") int modifiedBy) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.role_master_id = role_master_id;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public UserCreateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
