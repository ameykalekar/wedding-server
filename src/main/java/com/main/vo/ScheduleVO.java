package com.main.vo;

import java.time.LocalDateTime;

public class ScheduleVO {
	
	LocalDateTime startTime;
	LocalDateTime endTime;

	String dateDay;
	String dateMonth;
	String dateYear;
	String schStartTime;
	String schEndTime;
	String username;
	String ticketId;
	
	
	public ScheduleVO(){
	startTime = LocalDateTime.now();
	endTime = LocalDateTime.now();
	}
	
	
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	ScheduleVO(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}

	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String getDateYear() {
		return dateYear;
	}

	public void setDateYear(String dateYear) {
		this.dateYear = dateYear;
	}

	public String getSchStartTime() {
		return schStartTime;
	}

	public void setSchStartTime(String schStartTime) {
		this.schStartTime = schStartTime;
	}

	public String getSchEndTime() {
		return schEndTime;
	}

	public void setSchEndTime(String schEndTime) {
		this.schEndTime = schEndTime;
	}


	@Override
	public String toString() {
		return "ScheduleVO [startTime=" + startTime + ", endTime=" + endTime + ", dateDay=" + dateDay + ", dateMonth="
				+ dateMonth + ", dateYear=" + dateYear + ", schStartTime=" + schStartTime + ", schEndTime=" + schEndTime
				+ ", username=" + username + ", ticketId=" + ticketId + "]";
	}


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
}