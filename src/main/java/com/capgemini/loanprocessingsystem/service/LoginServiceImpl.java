package com.capgemini.loanprocessingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.LoginRepository;
import com.capgemini.loanprocessingsystem.entity.Login;

@Service 
public class LoginServiceImpl implements LoginService {

	private LoginRepository repository;
	
	@Autowired
	public LoginServiceImpl(LoginRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Login login(String email, String password) {
		return repository.login(email, password);
	}

	@Override
	public Login getUser(String email) {
		Optional<Login> result=repository.findById(email);
		Login login=null;
		if(result.isPresent()) {
			login=result.get();
			return login;
		}else {
			return null;
		}
	}

	@Override
	public Login saveUser(Login user) {
		return repository.save(user);
	}

	

}
