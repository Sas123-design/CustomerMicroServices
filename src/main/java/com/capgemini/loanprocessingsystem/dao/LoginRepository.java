package com.capgemini.loanprocessingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.loanprocessingsystem.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String>{
	
	@Query("from Login where email=?1 and password=?2")
	public Login login(String email,String password);
}
