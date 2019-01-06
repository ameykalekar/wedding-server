package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.BarcodePartMapping;
import com.main.entity.BarcodeProductMapping;
import com.main.entity.CheckList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeProductMappingRepository extends JpaRepository<BarcodeProductMapping, String> {

}
