package com.project.tpathshala.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_master")
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_master_id")
    private Integer id;
     
    @Column(nullable = false, length = 50, unique = true)
    private String name;
    
    @Column(nullable = true)
    private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(Integer id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
    
}
