package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,String> {

	@Query("select count(*) from User")
	public long countOfUsers();
	
	public Boolean existsByEmailid(String emailid);

}
