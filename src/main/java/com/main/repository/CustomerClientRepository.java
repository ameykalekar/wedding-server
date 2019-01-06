package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.CustomerClient;

public interface CustomerClientRepository extends JpaRepository<CustomerClient, Long>{
	
	List<CustomerClient> findByCompanyId(Long companyid);
}
