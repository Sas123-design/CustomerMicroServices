package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.loanprocessingsystem.entity.LoanPrograms;

public interface LoanProgramService {
	public List<LoanPrograms> findAllPrograms();
	
	public Page<LoanPrograms> getEmployees(int pageNo, int itemPerPage);
	
	public Page<LoanPrograms> getSortedEmployees(int pageNo, int itemPerPage, String fieldName); 
	
	public LoanPrograms findByName(Integer loanId);
	
	public LoanPrograms saveProgram(LoanPrograms loanProgram);
	
	public LoanPrograms updatePrograms(LoanPrograms loanPrograms);
	
	public void deleteProgram(Integer loanId); 
	
	public List<String> getPrograms();
}
