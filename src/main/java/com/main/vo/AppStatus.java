package com.main.vo;

public class AppStatus {

	private long openTickets;
	private long totalTickets;
	private long resolvedTickets;
	private long customerCount;
	private long ticketsInProgress;
	private long totalUserCount;
	public long getOpenTickets() {
		return openTickets;
	}
	public void setOpenTickets(long openTickets) {
		this.openTickets = openTickets;
	}
	public long getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(long totalTicekts) {
		this.totalTickets = totalTicekts;
	}
	public long getResolvedTickets() {
		return resolvedTickets;
	}
	public void setResolvedTickets(long resolvedTickets) {
		this.resolvedTickets = resolvedTickets;
	}
	public long getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(long customerCount) {
		this.customerCount = customerCount;
	}
	public long getTicketsInProgress() {
		return ticketsInProgress;
	}
	public void setTicketsInProgress(long ticketsInProgress) {
		this.ticketsInProgress = ticketsInProgress;
	}
	public long getTotalUserCount() {
		return totalUserCount;
	}
	public void setTotalUserCount(long totalUserCount) {
		this.totalUserCount = totalUserCount;
	}
	
	
}
