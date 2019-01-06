package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.main.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	
	@Query("select count(*) from Customer")
	public long countOfCustomers();
	
	
	
	
	

}
