package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.loanprocessingsystem.entity.Client;

public interface ClientService {
	
	public List<Client> showAllClients();
	
	public Page<Client> getClients(int pageNo, int itemPerPage);
	
	public Page<Client> getSortedClients(int pageNo, int itemPerPage, String fieldName);
	
	public Client getClientByEmail(String email);
	
	public Client saveClient(Client client);
	
	public void deleteClient(String email); 
}
