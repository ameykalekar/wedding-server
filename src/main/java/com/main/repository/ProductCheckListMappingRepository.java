package com.main.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.ProductCheckListMapping;
import com.main.entity.User;

public interface ProductCheckListMappingRepository extends JpaRepository<ProductCheckListMapping,String> {
	ProductCheckListMapping getOneByProductId(String productId);

}
