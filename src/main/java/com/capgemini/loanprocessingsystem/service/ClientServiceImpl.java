package com.capgemini.loanprocessingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.ClientRepository;
import com.capgemini.loanprocessingsystem.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository repository;	
	
	@Autowired
	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Client> showAllClients() {
		return repository.findAll();
	}

	@Override
	public Client getClientByEmail(String email) {
		Optional<Client> result = repository.findById(email);
		Client theClient=null;
		if(result.isPresent()) {
			theClient=result.get();
			return theClient;
		}
		return null;
	}

	@Override
	public Client saveClient(Client client) {
		return repository.save(client);
	}

	@Override
	public void deleteClient(String email) {
		repository.deleteById(email);
		
	}

	@Override
	public Page<Client> getClients(int pageNo, int itemPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemPerPage);
		return repository.findAll(pageable);
	}

	@Override
	public Page<Client> getSortedClients(int pageNo, int itemPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemPerPage, Sort.by(fieldName));
		return repository.findAll(pageable);
	}
	
}
