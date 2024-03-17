package com.project.tpathshala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tpathshala.config.AppConstants;
import com.project.tpathshala.payload.ApiListResponse;
import com.project.tpathshala.payload.ApiResponse;
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
	
	@PutMapping("/asign/{leadId}/{userId}")
	public ResponseEntity<ApiResponse> asigningLead(@PathVariable("leadId") Integer leadId, @PathVariable("userId") Integer user_id)
	{
		ApiResponse apiResponse = new ApiResponse();
		int asignLead = leadService.asignLead(leadId, user_id);
		
		if(asignLead == 1)
		{
			apiResponse.setSuccess(true);
			apiResponse.setMessage("Lead Asigned Successfuly");
		}
		else
		{
			apiResponse.setSuccess(false);
			apiResponse.setMessage("Something Went Wrong");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@GetMapping("/asign-list")
	public ResponseEntity<ApiListResponse> asignLeadList(@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, @RequestParam(value="pageSize", defaultValue = "5", required = false) Integer pageSize, @RequestParam(value = "sortBy", defaultValue = "lead_id", required = false) String sortBy, @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir)
	{
		ApiListResponse asignedLead = leadService.asignedLead(pageNumber,pageSize,sortBy,sortDir);
		return ResponseEntity.status(HttpStatus.OK).body(asignedLead);
	}
}
