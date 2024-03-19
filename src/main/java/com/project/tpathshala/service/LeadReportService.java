package com.project.tpathshala.service;

import org.springframework.stereotype.Service;

import com.project.tpathshala.payload.LeadReportRequest;

@Service
public interface LeadReportService {

	int createLeadReport(LeadReportRequest leadReportRequest);
}
