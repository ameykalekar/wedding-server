package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.BarcodePartMapping;
import com.main.entity.CheckList;
import com.main.entity.TicketBarcodeMapping;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBarcodeRepository extends JpaRepository<TicketBarcodeMapping, Long> {

	
	List<TicketBarcodeMapping> findAllByTicketId(Long ticketid);
	
	List<TicketBarcodeMapping> findAllByTicketIdAndBarcodeid (Long ticketid,Long barcodeid);
}
