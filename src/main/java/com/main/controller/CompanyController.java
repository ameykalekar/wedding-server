package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Company;
import com.main.entity.Product;
import com.main.entity.User;
import com.main.repository.CompanyRepository;
import com.main.repository.UserRepository;

@RestController
@CrossOrigin(origins={"*"})
public class CompanyController {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	UserController usercontroller;
	
	@RequestMapping("/api/GetAllCompanies")
	public List<Company> get(){ 
		return companyRepository.findAll();
	}
	
	@PostMapping("/api/SaveCompany")
	public ResponseEntity<Company> save(@RequestBody Company company){ 
		company.setActive("Y");
		
		if(!companyRepository.existsByEmailid(company.getEmailid()))
		{
		
		Company t=companyRepository.save(company);
		
		User user= new User();
		user.setActive("Y");
		user.setAddress(company.getAddress());
		user.setCompanyid(new Long(t.getCompanyid()));
		user.setMobilenumber(t.getMobilenumber());
		user.setType("admin");
		user.setUsername(t.getEmailid());
		user.setFirstname(t.getOwnername());
		
		usercontroller.save(user);
		
		
		return new ResponseEntity<Company>(t, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Company>(company, HttpStatus.FOUND);
			
		}
		
	}
}
