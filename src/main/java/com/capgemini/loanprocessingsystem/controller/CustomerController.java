package com.capgemini.loanprocessingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dao.UserRepository;
import com.capgemini.loanprocessingsystem.entity.ApplyLoan;
import com.capgemini.loanprocessingsystem.entity.LoanPrograms;
import com.capgemini.loanprocessingsystem.entity.User;
import com.capgemini.loanprocessingsystem.response.Response;
import com.capgemini.loanprocessingsystem.service.LoanApplicationService;
import com.capgemini.loanprocessingsystem.service.LoanProgramService;
import com.capgemini.loanprocessingsystem.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private LoanApplicationService loanApplicationService;
	
	@Autowired
	private LoanProgramService loanProgramService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/getprograms")
	public Response<List<LoanPrograms>> viewLoanPrograms(){
		List<LoanPrograms> list=loanProgramService.findAllPrograms();
		return new Response<List<LoanPrograms>>(false, "All Loan Programs", list);
	}
	
	@PostMapping("/adduser")
	public Response<User> saveUser(@Valid @RequestBody User user) {
		User theUser = repository.searchByEmail(user.getEmail());
		if (theUser == null) {
			user.setRole("ROLE_CUSTOMER");
			User user1 = userService.saveUser(user);
			if (user1 != null) {
				return new Response<User>(false, "User registered successfully", user1);
			} else {
				return new Response<User>(true, "User not registered successfully", null);
			}
		} else {
			return new Response<User>(true, "This user is alrady registered", null);
		}

	}
	
	@PostMapping("/makeloan/{email}")
	public Response<ApplyLoan> makeLoan(@PathVariable String email, @RequestBody ApplyLoan applyLoan){
		User user=userService.searchByEmail(email);
		applyLoan.setStatus("requested");
		applyLoan.setUser(user);
		if(loanApplicationService.saveApplication(applyLoan)==null) {
			return new Response<ApplyLoan>(true, "Application not saved", null);
		}else {
			return new Response<ApplyLoan>(false, "Application saved", applyLoan);
		}
	}
	
	@GetMapping("/viewapplications/{email}")
	public Response<User> viewApplications(@PathVariable String email){
		User user=userService.searchByEmail(email);
		if(user!=null) {
			return new Response<>(false, "All your applications", user);
		}else {
			return new Response<>(true, "no applications found", null);
		}
	}
	
}
