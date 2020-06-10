package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.entity.LoanPrograms;

@SpringBootTest
class LoanProgramServiceImplTest {

	@Autowired
	private LoanProgramService service;
	
	LoanPrograms program;
	LoanPrograms addProgram;
	
	
	@BeforeEach
	void addProgram() {
		program=new LoanPrograms();
		program.setInterestRate("8");
		program.setLoanType("Home Improvement Loan");
		program.setMaxTenurePeriod("20");
		program.setValidAge("18-70");
		addProgram=service.saveProgram(program);
	}
	
	@Test
	void testAddProgram() {
		assertNotNull(addProgram);
	}
	
	@Test
	void testSearchProgram() {
		LoanPrograms program=service.findByName(addProgram.getLoanId());
		assertNotNull(program);
	}
	
	@Test
	void getAllPrograms() {
		List<LoanPrograms> list=service.findAllPrograms();
		assertNotNull(list);
	}
	
	@AfterEach
	void testDeleteProgram() {
		service.deleteProgram(addProgram.getLoanId());
	}
	
}

