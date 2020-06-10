package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.dao.UserRepository;
import com.capgemini.loanprocessingsystem.entity.User;

@SpringBootTest
class UserServiceImplTest {

	
	@Autowired private UserRepository userRepository;
	 
	@Autowired
	private UserService userService;

	User user;
	User addUser = null;

	Optional<User> user1;
	
	
	

	@BeforeEach
	void addUser() {
		user = new User();
		user.setFullName("Nandita Pal");
		user.setAddress("100B, Belgharia Road");
		user.setEmail("nandi@gmail.com");
		user.setPhone("8989765432");
		user.setRole("ROLE_CUSTOMER");
//		user.setId(1);
		user.setAge(Integer.parseInt("22"));
		user.setPanNo("JHUIT7890H");
		user.setPassword("Nandita@123");
		addUser = userService.saveUser(user);
	}

	@Test
	void testAddUser() {
		assertNotNull(addUser);
	}

	@Test
	void testSearchUser() {
		User user = userService.findUserById(this.addUser.getUserid());
		assertNotNull(user);
	}

	@Test
	void testGetAllUsers() {
		List<User> userList = userService.findAllUser();
		assertNotNull(userList);
	}

	@AfterEach
	void testDeleteUser() {
		user = userService.findUserById(this.addUser.getUserid());
		userService.deleteUser(user.getUserid());
	}

	@Test
	void testAfterDelete() {
		assertNotNull(user);
	}

}