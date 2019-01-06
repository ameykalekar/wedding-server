package com.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import org.springframework.stereotype.Service;

import com.main.ApplicationContextProvider;
import com.main.entity.Ticket;
import com.main.entity.TicketAudit;
import com.main.repository.TicketAuditRepository;

@Service
public class AuditTicketService {

	
	
	public AuditTicketService() {
	}

	@PostUpdate
	void onPostUpdate(Object o) {
		if (o instanceof Ticket) {
			Ticket ticket = (Ticket) o;
			TicketAudit ticketAudit = new TicketAudit();
			ticketAudit.setTicketId(ticket.getId());
			ticketAudit.setTicketStatus(ticket.getStatus());
			ticketAudit.setAssignedTo(ticket.getAssignedTo());
			ticketAudit.setUpdatedDate(new Date());
			ticketAudit.setUpdatedBy(ticket.getUpdatedBy());
			getRepo().save(ticketAudit);
			}

	}

	@PostPersist
	void onPostPersist(Object o) {
		if (o instanceof Ticket) {
			Ticket ticket = (Ticket) o;
			TicketAudit ticketAudit = new TicketAudit();
			ticketAudit.setTicketId(ticket.getId());
			ticketAudit.setTicketStatus(ticket.getStatus());
			ticketAudit.setAssignedTo(ticket.getAssignedTo());
			ticketAudit.setUpdatedDate(new Date());
			ticketAudit.setUpdatedBy(ticket.getUpdatedBy());
        	getRepo().save(ticketAudit);
		}

	}

	private TicketAuditRepository getRepo(){
        return ApplicationContextProvider.getContext().getBean(TicketAuditRepository.class);
    }
}
