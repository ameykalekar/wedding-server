package com.main.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "USERNAME", nullable = false)
	String username;


	@Column(name = "TICKET_ID", nullable = false)
	String ticketId;

	@Column(name = "START_TIME", nullable = false)
	Date startDateTime;

	@Column(name = "END_TIME", nullable = false)
	Date endDateTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
	public String getFormatStartTime(){
		return startDateTime!=null ? format.format(this.startDateTime):"";
	}

	public String getFormatEndTime(){
			
		return endDateTime!=null ? format.format(this.endDateTime):"";
	}
	
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", username=" + username + ", ticketId=" + ticketId + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + "]";
	}

}
