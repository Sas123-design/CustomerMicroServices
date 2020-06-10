package com.capgemini.loanprocessingsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userid;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Pattern(regexp = "[A-Z a-z]{2,20}", message="name can't have digits")
	@Column(name="fullname")
	private String fullName;
	
	@Pattern(regexp = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,}", message="at least 1 uppercase,1 lowercase, 1 special char, 1 digit and 8-15 characters")
	@Column(name="password")
	private String password;
	
	@Column(name="address")
	private String address;
	
	 
	@Column(name="phone")
	@Pattern(regexp = "[6789][0-9]{9}", message="phone number must be of 10 digits, starts with 6/7/8/9")
	private String phone;
	
	@NotNull
	@Pattern(regexp ="([A-Z]){5}([0-9]){4}([A-Z]){1}$", message="Please enter a valid  PAN, eg: ABCDE1234F" )
	@Column(name="pan_no")
	private String panNo;
	
	@Column(name="role")
	private String role;
		
	@Column(name="age")
	//@Pattern(regexp = "^0*(1[89]|[2-6][0-9]|70)$", message="must be between 18 and 70")
	private int age;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<ApplyLoan> applyLoan;

	public User(int userid, String email, String fullName, String password, String address, String phone, String role,
			int age) {
		this.userid = userid;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.age = age;
	}
	
	public User() {
		
	}
	
	
}
