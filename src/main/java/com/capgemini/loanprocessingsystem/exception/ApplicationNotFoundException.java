package com.capgemini.loanprocessingsystem.exception;

public class ApplicationNotFoundException extends RuntimeException{
	public ApplicationNotFoundException(String message) {
		super(message);
	}
}
