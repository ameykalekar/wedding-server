package com.main.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.PartProductMapping;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.User;

public interface PartProductMappingRepository extends JpaRepository<PartProductMapping,String> {
	PartProductMapping getOneByProductId(String productId);
	
	List<PartProductMapping> findAllByProductId(String productId);

}
