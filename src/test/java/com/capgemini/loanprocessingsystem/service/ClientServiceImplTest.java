package com.capgemini.loanprocessingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.loanprocessingsystem.entity.Client;

@SpringBootTest
class ClientServiceImplTest {
	@Autowired
	private ClientService service;
	Client client;
	Client theClient;
	@BeforeEach
	void addClient() {
		client=new Client();
		client.setName("Emmy Adams");
		client.setEmail("emmy@gmail.com");
		client.setCity("Bangalore");
		client.setPhone("9089765432");
		client.setPostalCode("890876");
		client.setRole("ROLE_LAD");
		theClient=service.saveClient(client);
	}
	@Test
	void testAddClient() {
		assertNotNull(theClient);
	}

	@Test
	void testGetAllClients() {
		List<Client> clients=service.showAllClients();
		assertNotNull(clients);
	}
	@Test
	void testSearchClient() {
		service.getClientByEmail("emmy@gmail.com");
	}
	@AfterEach
	void testDeleteClient() {
		service.deleteClient(theClient.getEmail());
	}
	
}
