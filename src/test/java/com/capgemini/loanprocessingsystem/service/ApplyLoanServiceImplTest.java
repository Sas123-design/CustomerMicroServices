package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dao.LoanApplicationRepository;
import com.capgemini.loanprocessingsystem.entity.ApplyLoan;

@SpringBootTest
class ApplyLoanServiceImplTest {

	@Autowired
	private LoanApplicationService service;
	
	ApplyLoan applyLoan;
	ApplyLoan apply;

	
	@BeforeEach
	void applyLoan() {
		applyLoan=new ApplyLoan();
		applyLoan.setLoanType("Home Purchase Loan");
		applyLoan.setAge("22");
		applyLoan.setLoanAmount("2999.0");
		applyLoan.setOccupation("Developer");
		applyLoan.setSalary("22000.0");
		apply=service.saveApplication(applyLoan);
	}
	
	@Test
	void testAddApplication() {
		assertNotNull(apply);
	}
	
	@Test
	void testGetAllApplications() {
		List<ApplyLoan> list=service.findAllApplications();
		assertNotNull(list);
	}
	
	@Test
	void tesrSearchApplication() {
		ApplyLoan apply=service.findApplicationById(this.apply.getLoanId());
	}
}
