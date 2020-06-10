package com.capgemini.loanprocessingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


import lombok.Data;

@Data
@Entity
@Table(name="loanprogram_table")
public class LoanPrograms {
	
	
	@Pattern(regexp = "[A-Z a-z]{3,20}", message="only letters are allowed, 3-20 charachters")
	@Column(name="loan_type")
	private String loanType;
	
	@Pattern(regexp = "^0*([6-9]|1[0-9]|20)$", message = "enter rate between 6-20")
	@Column(name="interest_rate")
	private String interestRate;
	
	@Pattern(regexp="^0*(1[89]|2[0-4])-0*([4-6][0-9]|70)$", message="age range is 18-70")
	@Column(name="valid_age")
	private String validAge;
	
	@Pattern(regexp = "^0*([1-9]|[12][0-9]|30)$", message="enter a value between 1-30")
	@Column(name="max_tenure_period")
	private String maxTenurePeriod;
	
	@Id
	@Column(name="loan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
		 
}
