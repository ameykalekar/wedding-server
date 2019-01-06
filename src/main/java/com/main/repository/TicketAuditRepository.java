package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.TicketAudit;

public interface TicketAuditRepository extends JpaRepository<TicketAudit, Long>{

	public List<TicketAudit> findByTicketId(Long id);
	public List<TicketAudit> findByTicketStatus(String status);
	public List<TicketAudit> findByTicketIdAndTicketStatus(Long id,String status);
}
