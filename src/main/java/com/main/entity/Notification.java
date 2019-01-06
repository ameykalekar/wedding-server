package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="STAUS_CHANGE")
	boolean statusChange;
	
	@Column(name="TICKET_CREATION")
	boolean ticketCreation;
	
	@Column(name="TICKET_ASSIGNMENT")
	boolean ticketAssignment;
	
	@Column(name="USERNAME")
	String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isStatusChange() {
		return statusChange;
	}

	public void setStatusChange(boolean statusChange) {
		this.statusChange = statusChange;
	}

	public boolean isTicketCreation() {
		return ticketCreation;
	}

	public void setTicketCreation(boolean ticketCreation) {
		this.ticketCreation = ticketCreation;
	}

	public boolean isTicketAssignment() {
		return ticketAssignment;
	}

	public void setTicketAssignment(boolean ticketAssignment) {
		this.ticketAssignment = ticketAssignment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", statusChange=" + statusChange + ", ticketCreation=" + ticketCreation
				+ ", ticketAssignment=" + ticketAssignment + ", username=" + username + "]";
	}
	
}
