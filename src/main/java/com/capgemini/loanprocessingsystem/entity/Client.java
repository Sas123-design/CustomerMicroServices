package com.capgemini.loanprocessingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="client_table")
public class Client {
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Z a-z]{2,20}", message="name can't have digits, 2-20 characters")
	@Column(name="full_name")
	private String name;
	
	@NotEmpty
	@NotNull
	@Id
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z a-z]*", message="name can't have digits")
	@Column(name="city")
	private String city;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[1-9][0-9]{5}$", message="postalcode must be a 6 digit number, starts with 1-9")
	@Column(name="postal_code")
	private String postalCode;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[6789][0-9]{9}", message="must be a 10 digit number, starts with 6/7/8/9")
	@Column(name="phone")
	private String phone;
	
	@NotEmpty
	@NotNull
	@Column(name="role")
	private String role;
	
}
