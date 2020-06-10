package com.capgemini.loanprocessingsystem.response;

import java.util.List;

import com.capgemini.loanprocessingsystem.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data 
@JsonPropertyOrder({"error","message"})
public class UserResponse {
	
	@JsonProperty
	private boolean error;
	private String message;
	private User user;
	private List<User> userList;
	
	
	
}
