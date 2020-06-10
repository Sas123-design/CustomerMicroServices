package com.capgemini.loanprocessingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.loanprocessingsystem.entity.ApplyLoan;
import com.capgemini.loanprocessingsystem.entity.Client;
import com.capgemini.loanprocessingsystem.entity.LoanPrograms;
import com.capgemini.loanprocessingsystem.entity.Login;
import com.capgemini.loanprocessingsystem.entity.User;
import com.capgemini.loanprocessingsystem.response.Response;


@ControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Response<Client>> handleException(ClientNotFoundException ex){
		Response<Client> response = new Response<>(true, ex.getMessage(),null);
		return new ResponseEntity<Response<Client>>(response,HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<LoanPrograms>> handleException(LoanProgramNotFoundException ex){
		Response<LoanPrograms> response = new Response<>(true, ex.getMessage(),null);
		return new ResponseEntity<Response<LoanPrograms>>(response,HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler
	public ResponseEntity<Response<ApplyLoan>> handleException(ApplicationNotFoundException ex){
		Response<ApplyLoan> response = new Response<>(true, ex.getMessage(),null);
		return new ResponseEntity<Response<ApplyLoan>>(response,HttpStatus.NOT_FOUND );
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<Response<User>> handleException(UserNotFoundException ex){
		Response<User> response = new Response<>(true, ex.getMessage(),null);
		return new ResponseEntity<Response<User>>(response,HttpStatus.NOT_FOUND );
	}
}
