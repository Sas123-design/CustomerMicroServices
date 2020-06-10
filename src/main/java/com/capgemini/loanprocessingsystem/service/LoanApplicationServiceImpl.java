package com.capgemini.loanprocessingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoanApplicationRepository;
import com.capgemini.loanprocessingsystem.entity.ApplyLoan;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	private LoanApplicationRepository loanApplicationRepository;

	@Autowired
	public LoanApplicationServiceImpl(LoanApplicationRepository loanApplicationRepository) {
		this.loanApplicationRepository = loanApplicationRepository;
	}

	@Override
	public List<ApplyLoan> findAllApplications() {
		return loanApplicationRepository.findAll();
	}

	@Override
	public ApplyLoan findApplicationById(int applicationId) {
		Optional<ApplyLoan> result = loanApplicationRepository.findById(applicationId);
		ApplyLoan theApplication = null;
		if (result.isPresent()) {
			theApplication = result.get();
			return theApplication;
		}
		return null;
	}

	@Override
	public ApplyLoan saveApplication(ApplyLoan applocation) {
		return loanApplicationRepository.save(applocation);
	}

	@Override
	public void deleteApplication(int applicationId) {
		loanApplicationRepository.deleteById(applicationId);
	}

	@Override
	public Page<ApplyLoan> pageRejected(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanApplicationRepository.findAllRejected(pageable);
	}

	@Override
	public Page<ApplyLoan> pageApproved(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanApplicationRepository.findAllApproved(pageable);
	}

	@Override
	public Page<ApplyLoan> pageRequested(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanApplicationRepository.findAllRequested(pageable);
	}

	
	@Override
	public Page<ApplyLoan> getApplications(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanApplicationRepository.findAll(pageable);
	}

	@Override
	public Page<ApplyLoan> getSortedApplications(int pageNo, int itemsPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage, Sort.by(fieldName));
		return loanApplicationRepository.findAll(pageable);
	}

	@Override
	public List<ApplyLoan> getRequestedApplications() {
		return loanApplicationRepository.getRequestedApplications();
	}

	@Override
	public List<ApplyLoan> getApprovedApplications() {
		return loanApplicationRepository.getApprovedApplications();
	}

	@Override
	public List<ApplyLoan> getRejectedApplications() {
		return loanApplicationRepository.getRejectedApplications();
	}

	@Override
	public ApplyLoan makeApproved(int loanId) {
		Optional<ApplyLoan> result = loanApplicationRepository.findById(loanId);
		ApplyLoan applyLoan;
		if (result != null) {
			applyLoan = result.get();
			applyLoan.setStatus("approved");
			loanApplicationRepository.save(applyLoan);
			return applyLoan;
		} else {
			return null;
		}

	}

	@Override
	public ApplyLoan makeRejected(int loanId) {
		Optional<ApplyLoan> result = loanApplicationRepository.findById(loanId);
		ApplyLoan applyLoan;
		if (result != null) {
			applyLoan = result.get();
			applyLoan.setStatus("rejected");
			loanApplicationRepository.save(applyLoan);
			return applyLoan;
		}else {
			return null;
		}
		
	}

	
}
