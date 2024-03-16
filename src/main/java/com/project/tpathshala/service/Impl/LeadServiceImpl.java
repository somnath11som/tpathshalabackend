package com.project.tpathshala.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tpathshala.component.JwtTokenUtil;
import com.project.tpathshala.exceptions.ResourceNotFoundException;
import com.project.tpathshala.model.Lead;
import com.project.tpathshala.model.User;
import com.project.tpathshala.payload.ApiListResponse;
import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.payload.UserCreateRequest;
import com.project.tpathshala.repository.LeadRepository;
import com.project.tpathshala.repository.UserRepository;
import com.project.tpathshala.service.LeadService;
import com.project.tpathshala.service.UserIdFromToken;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	LeadRepository leadRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private UserIdFromToken userIdFromToken;
	
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

	
	@Override
	public int asignLead(Integer lead_id, Integer user_id) {
		// TODO Auto-generated method stub
		int asignBy = userIdFromToken.id();
		userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User ", " Id ", user_id));
		leadRepository.findById(lead_id).orElseThrow(()-> new ResourceNotFoundException("Lead ", " Id ", lead_id));
		try
		{
			leadRepository.asignLead(lead_id, user_id, asignBy, new Date());
			return 1;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public ApiListResponse asignedLead(Integer pageNumber, Integer pageSize, String sortBy,String sortDir) {
		// TODO Auto-generated method stub
		
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc"))
		{
			sort = Sort.by(sortBy).ascending();
		}
		else
		{
			sort = Sort.by(sortBy).descending();
		}
		Pageable page = PageRequest.of(pageNumber,pageSize,sort);
		
		Page<Lead> leadAll = leadRepository.findAsignedLead(page);
		List<Lead> findAll = leadAll.getContent();
		List<LeadRequest> collect = findAll.stream().map(lead->this.LeadToDto(lead)).collect(Collectors.toList());
		
		ApiListResponse apiListResponse = new ApiListResponse();
		apiListResponse.setContent(collect);
		apiListResponse.setLastPage(leadAll.isLast());
		apiListResponse.setPageNumber(leadAll.getNumber());
		apiListResponse.setPageSize(leadAll.getSize());
		apiListResponse.setTotalElements(leadAll.getTotalElements());
		apiListResponse.setTotalPages(leadAll.getTotalPages());
		
		
//		List<Lead> asignedLead = leadRepository.asignedLead();
//		
//		List<LeadRequest> asignedLeadRequest = asignedLead.stream().map(lead->this.LeadToDto(lead)).collect(Collectors.toList());
		return apiListResponse;
	}

	@Override
	public ApiListResponse unAsignedLead(Integer pageNumber, Integer pageSize, String sortBy,String sortDir) {
		// TODO Auto-generated method stub
		
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc"))
		{
			sort = Sort.by(sortBy).ascending();
		}
		else
		{
			sort = Sort.by(sortBy).descending();
		}
		Pageable page = PageRequest.of(pageNumber,pageSize,sort);
		
		Page<Lead> leadAll = leadRepository.findUnAsignedLead(page);
		List<Lead> findAll = leadAll.getContent();
		List<LeadRequest> collect = findAll.stream().map(lead->this.LeadToDto(lead)).collect(Collectors.toList());
		
		ApiListResponse apiListResponse = new ApiListResponse();
		apiListResponse.setContent(collect);
		apiListResponse.setLastPage(leadAll.isLast());
		apiListResponse.setPageNumber(leadAll.getNumber());
		apiListResponse.setPageSize(leadAll.getSize());
		apiListResponse.setTotalElements(leadAll.getTotalElements());
		apiListResponse.setTotalPages(leadAll.getTotalPages());
		
		return apiListResponse;
		
//		List<Lead> unAsignedLead = leadRepository.UnAsignedLead();
//		
//		List<LeadRequest> unAsignedLeadRequest = unAsignedLead.stream().map(lead->this.LeadToDto(lead)).collect(Collectors.toList());
//		return unAsignedLeadRequest;
	}
}
