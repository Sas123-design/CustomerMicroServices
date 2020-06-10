package com.capgemini.loanprocessingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Generated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="applyloan_table")
@NoArgsConstructor
@AllArgsConstructor
public class ApplyLoan {
	
	@NotNull
	@NotEmpty
	@Pattern(regexp ="[A-Z a-z]*" ,message="can't have digits")
	@Column(name="loan_type")
	private String loanType;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^0*(1[89]|[2-6][0-9]|70)$", message="must be between 18 and 70")
	@Column(name="age")
	private String age;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp ="[A-Z a-z]*" ,message="can't have digits")
	@Column(name="occupation")
	private String occupation;
	
	@NotNull
	@Pattern(regexp ="^[0-9]+(\\.[0-9]{1,2})?$", message="Invalid salary" )
	@Column(name="salary")
	private String salary;
	
	@NotNull
	//@Pattern(regexp ="^[0-9]+(\\.[0-9]{1,2})?$", message="Invalid salary" )
	@Column(name="loan_amount")
	private String loanAmount;
	
	
	@Id
	@Column(name="loan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	
	@Column(name="status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonBackReference
	private User user;
	
		
}
