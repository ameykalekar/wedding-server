package com.main.vo;

import java.util.List;

import com.main.entity.Ticket;

public class TicketInfo {
	
	Ticket ticket;
	List<ProductInfo> productInfos;
	
	private  String formattedStartScheduledTime;
	private String formattedEndScheduledTime;
	
	public String getFormattedStartScheduledTime() {
		return formattedStartScheduledTime;
	}
	public void setFormattedStartScheduledTime(String formattedStartScheduledTime) {
		this.formattedStartScheduledTime = formattedStartScheduledTime;
	}
	public String getFormattedEndScheduledTime() {
		return formattedEndScheduledTime;
	}
	public void setFormattedEndScheduledTime(String formattedEndScheduledTime) {
		this.formattedEndScheduledTime = formattedEndScheduledTime;
	}
	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return the productInfos
	 */
	public List<ProductInfo> getProductInfos() {
		return productInfos;
	}
	/**
	 * @param productInfos the productInfos to set
	 */
	public void setProductInfos(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketInfo [ticket=" + ticket + ", productInfos=" + productInfos + "]";
	}
		

}
