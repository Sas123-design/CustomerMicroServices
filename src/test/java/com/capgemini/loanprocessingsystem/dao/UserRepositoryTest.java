package com.capgemini.loanprocessingsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.loanprocessingsystem.entity.ApplyLoan;
import com.capgemini.loanprocessingsystem.entity.User;

class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	User user;
	
	@BeforeEach
	void saveUser() {
		User user=new User();
		user.setFullName("Ashish");
		user.setAddress("101 Kallyan Nagar");
		user.setUserid(10);
		user.setEmail("ashish@gmail.com");
		user.setPhone("9089765432");
		user.setRole("ROLE_ADMIN");
		user.setAge(22);
		user.setPassword("Ashish@123");
		user.setPanNo("HUJNH6765F");
		this.user=userRepository.save(user);
		
	}
	
	@Test
	void testSaveUser(){
		assertNotNull(user);
	}


}
