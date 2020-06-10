package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.loanprocessingsystem.entity.LoanPrograms;

public interface LoanProgramRepository extends JpaRepository<LoanPrograms, Integer>{
	
	@Query("select loanType from LoanPrograms")
	public List<String> getAllprograms();
}
