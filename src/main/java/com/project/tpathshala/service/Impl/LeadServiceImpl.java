package com.project.tpathshala.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tpathshala.model.Lead;
import com.project.tpathshala.model.User;
import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.payload.UserCreateRequest;
import com.project.tpathshala.repository.LeadRepository;
import com.project.tpathshala.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	LeadRepository leadRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public LeadRequest createLead(LeadRequest lead) {
		// TODO Auto-generated method stub
		Lead leadSave = leadRepository.saveAndFlush(dtoToLead(lead));
		return LeadToDto(leadSave);
	}

	private Lead dtoToLead(LeadRequest leadRequest)
	{
		Lead lead = modelMapper.map(leadRequest, Lead.class);
		return lead;
	}
	
	private LeadRequest LeadToDto(Lead lead)
	{
		LeadRequest leadRequest = modelMapper.map(lead, LeadRequest.class);
		return leadRequest;
	}
}
