package com.project.tpathshala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tpathshala.payload.ApiResponse;
import com.project.tpathshala.payload.LeadReportRequest;
import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.service.LeadReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("lead-reprt")
public class LeadReportController {

	@Autowired
	LeadReportService leadReportService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> createLeadReport(@Valid @RequestBody LeadReportRequest leadReportRequest)
	{
		ApiResponse apiResponse = new ApiResponse();
		int submitLeadReport = leadReportService.createLeadReport(leadReportRequest);
		
		if(submitLeadReport == 1)
		{
			apiResponse.setSuccess(true);
			apiResponse.setMessage("Lead Report Added Successfuly");
		}
		else
		{
			apiResponse.setSuccess(false);
			apiResponse.setMessage("Something Went Wrong");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		
	}
}
