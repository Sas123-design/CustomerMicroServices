package com.capgemini.loanprocessingsystem.exception;

public class ClientNotFoundException extends RuntimeException{
	public ClientNotFoundException(String message) {
		super(message);
	}
}
