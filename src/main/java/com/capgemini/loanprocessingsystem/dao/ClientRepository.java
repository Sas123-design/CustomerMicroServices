package com.capgemini.loanprocessingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.loanprocessingsystem.entity.Client;

public interface ClientRepository extends JpaRepository<Client, String>{

}
