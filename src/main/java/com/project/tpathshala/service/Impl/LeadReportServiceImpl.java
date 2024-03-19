package com.project.tpathshala.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tpathshala.exceptions.ResourceNotFoundException;
import com.project.tpathshala.model.Lead;
import com.project.tpathshala.model.LeadReport;
import com.project.tpathshala.payload.LeadReportRequest;
import com.project.tpathshala.payload.LeadRequest;
import com.project.tpathshala.repository.LeadReportRepository;
import com.project.tpathshala.repository.LeadRepository;
import com.project.tpathshala.repository.UserRepository;
import com.project.tpathshala.service.LeadReportService;

@Service
public class LeadReportServiceImpl implements LeadReportService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	LeadRepository leadRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LeadReportRepository leadReportRepository;

	@Override
	public int createLeadReport(LeadReportRequest leadReportRequest) {
		// TODO Auto-generated method stub
		userRepository.findById(leadReportRequest.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User ", " Id ", leadReportRequest.getUserId()));
		leadRepository.findById(leadReportRequest.getLeadId()).orElseThrow(()-> new ResourceNotFoundException("Lead ", " Id ", leadReportRequest.getLeadId()));
		try
		{
			leadReportRepository.saveAndFlush(dtoToLeadReport(leadReportRequest));
			return 1;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
			return 0;
		}
	}
	
	private LeadReport dtoToLeadReport(LeadReportRequest leadReportRequest)
	{
		LeadReport leadReport = modelMapper.map(leadReportRequest, LeadReport.class);
		return leadReport;
	}
	
	private LeadReportRequest LeadReportToDto(LeadReport leadReport)
	{
		LeadReportRequest leadReportRequest = modelMapper.map(leadReport, LeadReportRequest.class);
		return leadReportRequest;
	}

}
