package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TICKETBARCODE")
public class TicketBarcodeMapping extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name="TICKETID")
	protected Long ticketId;
	
	@Column(name="BARCODEID")
	protected Long barcodeid;
	
	@Column(name="UPDATEBY")
	protected String updateby;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return ticketId;
	}

	/**
	 * @param ticketid the productId to set
	 */
	public void setProductId(Long ticketid) {
		this.ticketId = ticketid;
	}

	/**
	 * @return the barcodeid
	 */
	public Long getBarcodeid() {
		return barcodeid;
	}

	/**
	 * @param barcodeid the barcodeid to set
	 */
	public void setBarcodeid(Long barcodeid) {
		this.barcodeid = barcodeid;
	}

	/**
	 * @return the updateby
	 */
	public String getUpdateby() {
		return updateby;
	}

	/**
	 * @param updateby the updateby to set
	 */
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	/**
	 * 
	 */
	public TicketBarcodeMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ticketid
	 * @param barcodeid
	 * @param updateby
	 */
	public TicketBarcodeMapping(Long ticketid, Long barcodeid, String updateby) {
		super();
		this.ticketId = ticketid;
		this.barcodeid = barcodeid;
		this.updateby = updateby;
	}

	
}
