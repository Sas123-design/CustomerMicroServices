
package com.capgemini.loanprocessingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.UserRepository;
import com.capgemini.loanprocessingsystem.entity.ApplyLoan;
import com.capgemini.loanprocessingsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	
	  @Autowired 
	  private PasswordEncoder passwordEncoder;
	 

	public UserServiceImpl() {

	}

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(int id) {
		Optional<User> result = userRepository.findById(id);
		User theUser = null;
		if (result.isPresent()) {
			theUser = result.get();
			return theUser;
		}
		return null;
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> requestedApplications() {
		return userRepository.requestedApplications();
	}

	@Override
	public List<User> rejectedApplications() {
		return userRepository.rejectedApplications();
	}

	@Override
	public List<User> approvedApplications() {
		return userRepository.approvedApplications();
	}

	@Override
	public User searchByEmail(String email) {
		return userRepository.searchByEmail(email);
	}

}
