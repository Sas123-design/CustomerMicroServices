package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.loanprocessingsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select c from User c where role='ROLE_LAD'")
	List<User> viewClients();
	
	/*
	 * @Query("select c from User c where role='ROLE_LAD'") Page<User>
	 * viewClients(Pageable pageable);
	 */
	
	@Query("select c from User c where role='ROLE_CUSTOMER'")
	List<User> viewCustomer();
	
	/*
	 * @Query("select c from User c where role='ROLE_CUSTOMER'") Page<User>
	 * viewCustomer(Pageable pageable);
	 */
	
	@Query("select max(id) from User where role = 'ROLE_CUSTOMER'")
	int retrieveId();
	
	@Query(value = "select DISTINCT u from User u INNER JOIN u.applyLoan a where a.status='requested'")
	List<User> requestedApplications();
	
	@Query(value = "select DISTINCT u from User u INNER JOIN u.applyLoan a where a.status='approved'")
	List<User> approvedApplications();
	
	@Query(value = "select DISTINCT u from User u INNER JOIN u.applyLoan a where a.status='rejected'")
	List<User> rejectedApplications();
	
	@Query("from User where email=?1")
	User searchByEmail(String email);
	
	@Query("from User where email=?1 and password=?2")
	User login(String email, String password); 

}
