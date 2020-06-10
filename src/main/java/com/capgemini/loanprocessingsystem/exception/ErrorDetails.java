package com.capgemini.loanprocessingsystem.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDetails<T> {
	private Date timestamp;
	private String message;
	private String details;
	private T data;
}
