package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.BarcodePartMapping;
import com.main.entity.CheckList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodePartMappingRepository extends JpaRepository<BarcodePartMapping, Long> {

	List<BarcodePartMapping> findByBarcodeid(Long Barcodeid);
	
}
