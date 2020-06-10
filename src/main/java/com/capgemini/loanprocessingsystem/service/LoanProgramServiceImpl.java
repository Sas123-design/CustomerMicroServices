package com.capgemini.loanprocessingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoanProgramRepository;
import com.capgemini.loanprocessingsystem.entity.LoanPrograms;

@Service
public class LoanProgramServiceImpl implements LoanProgramService {

	private LoanProgramRepository loanProgramRepository;
	
	@Autowired
	public LoanProgramServiceImpl(LoanProgramRepository loanProgramRepository) {
		this.loanProgramRepository = loanProgramRepository;
	}

	@Override
	public List<LoanPrograms> findAllPrograms() {
		return loanProgramRepository.findAll();
	}

	@Override
	public LoanPrograms findByName(Integer type) {
		Optional<LoanPrograms> result = loanProgramRepository.findById(type);
		LoanPrograms theLoanProgram=null;
		if(result.isPresent()) {
			theLoanProgram=result.get();
			return theLoanProgram;
		}
		return null;
	}

	@Override
	public LoanPrograms saveProgram(LoanPrograms program) {
		Optional<LoanPrograms> result = loanProgramRepository.findById(program.getLoanId());
		if(result.isPresent()) {
			return null;
		}else {
			return loanProgramRepository.save(program);
		}
	}
	
	@Override
	public LoanPrograms updatePrograms(LoanPrograms loanProgram) {
		return loanProgramRepository.save(loanProgram);
	}
	
	@Override
	public void deleteProgram(Integer type) {
		loanProgramRepository.deleteById(type);

	}

	@Override
	public Page<LoanPrograms> getEmployees(int pageNo, int itemPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemPerPage);
		return loanProgramRepository.findAll(pageable);
	}

	@Override
	public Page<LoanPrograms> getSortedEmployees(int pageNo, int itemPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemPerPage, Sort.by(fieldName));
		return loanProgramRepository.findAll(pageable);
	}

	@Override
	public List<String> getPrograms() {
		return loanProgramRepository.getAllprograms();
	}

	

}
