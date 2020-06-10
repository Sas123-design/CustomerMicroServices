package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.entity.ApplyLoan;
import com.capgemini.loanprocessingsystem.entity.User;

public interface UserService {
	public List<User> findAllUser();

	public User findUserById(int id);

	public User saveUser(User user);

	public List<User> requestedApplications();

	public List<User> rejectedApplications();

	public List<User> approvedApplications();

	public void deleteUser(int id);
	
	public User searchByEmail(String email);
	
	
}
