package com.project.tpathshala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.tpathshala.payload.ApiListResponse;
import com.project.tpathshala.payload.LeadRequest;

@Service
public interface LeadService {

	LeadRequest createLead(LeadRequest lead);
	int asignLead(Integer lead_id, Integer user_id);
	ApiListResponse asignedLead(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);
	ApiListResponse unAsignedLead(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);
}
