package com.main.enums;



/**
 * @author admin
 *
 */
public enum TicketStatus {
	
	SUBMITTED("SUBMITTED"), REJECTED("REJECTED"), INPROGRESS("INPROGRESS");
	
	private String status;

	/**
	 * @param status
	 */
	private TicketStatus(String status) {
		this.status = status;
	}

	
	
	
}
