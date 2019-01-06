package com.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/api/getCustomers")
	public List<Customer> getAllCustomer(){
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}
}
