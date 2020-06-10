package com.capgemini.loanprocessingsystem.exception;

import java.util.ArrayList;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.loanprocessingsystem.response.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<?> handleCustomValidationError(MethodArgumentNotValidException ex ){
		Response<?> response=new Response(true,ex.getBindingResult().getFieldError().getDefaultMessage() , new ArrayList());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
