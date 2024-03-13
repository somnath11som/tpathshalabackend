package com.project.tpathshala.service;

import org.springframework.stereotype.Service;

import com.project.tpathshala.payload.LeadRequest;

@Service
public interface LeadService {

	LeadRequest createLead(LeadRequest lead);
}
