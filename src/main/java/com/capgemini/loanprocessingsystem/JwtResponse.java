package com.capgemini.loanprocessingsystem;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String email;
	private final Boolean error;
	private final String role;
	private final String fullName;

	public JwtResponse(String jwttoken, String email, boolean error, String role, String fullName) {
		this.jwttoken = jwttoken;
		this.email = email;
		this.error = error;
		this.role = role;
		this.fullName=fullName;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getError() {
		return error;
	}

	public String getRole() {
		return role;
	}
	
	public String getFullName() {
		return fullName;
	}
}
