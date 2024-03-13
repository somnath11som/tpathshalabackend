package com.project.tpathshala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.payload.UserCreateRequest;
import com.project.tpathshala.service.LeadService;
import com.project.tpathshala.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lead")
public class LeadController {

	@Autowired
	LeadService leadService;
	
	@PostMapping("/save")
	public ResponseEntity<LeadRequest> createUser(@Valid @RequestBody LeadRequest leadRequest)
	{
		try
		{
			LeadRequest createLead = leadService.createLead(leadRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(createLead);
		}
		catch(Exception e)
		{
			return ResponseEntity.internalServerError().build();
		}
		
	}
}
