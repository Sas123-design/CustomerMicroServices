package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.loanprocessingsystem.entity.ApplyLoan;

public interface LoanApplicationService {
	public List<ApplyLoan> findAllApplications();
	
	public Page<ApplyLoan> getApplications(int pageNo, int itemsPerPage);
	
	public Page<ApplyLoan> getSortedApplications(int pageNo, int itemsPerPage, String fieldName);
	
	public ApplyLoan findApplicationById(int ApplicationId);
	
	public ApplyLoan saveApplication(ApplyLoan applocation);
	
	public void deleteApplication(int ApplicationId);
	
	public List<ApplyLoan> getRequestedApplications();
	
	public List<ApplyLoan> getApprovedApplications();
	
	public List<ApplyLoan> getRejectedApplications();
	 
	public ApplyLoan makeApproved(int loanId);
	
	public ApplyLoan makeRejected(int loanId);
	
	public Page<ApplyLoan> pageRejected(int pageNo, int itemsPerPage);
	
	public Page<ApplyLoan> pageApproved(int pageNo, int itemsPerPage);
	
	public Page<ApplyLoan> pageRequested(int pageNo, int itemsPerPage);
	
	
}
