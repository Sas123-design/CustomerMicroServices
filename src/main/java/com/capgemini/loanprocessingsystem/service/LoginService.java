package com.capgemini.loanprocessingsystem.service;

import com.capgemini.loanprocessingsystem.entity.Login;

public interface LoginService {
	
	public Login getUser(String email);
	
	public Login login(String email, String password); 
	
	public Login saveUser(Login user);
}
