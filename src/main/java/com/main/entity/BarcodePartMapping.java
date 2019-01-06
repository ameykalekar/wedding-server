package com.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_BARCODEPART")
public class BarcodePartMapping {
	
	@Id
	@Column(name="ID", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name="PARTID")
	protected Long partId;
	

	@Column(name="BARCODEID")
	protected Long barcodeid;
	
	

	@Column(name="QUANTITY")
	protected Long quantity;
	
	


	
	
	@Column(name="UPDATEBY")
	protected String updateby;

	
	





	/**
	 * @return the partId
	 */
	public Long getPartId() {
		return partId;
	}






	/**
	 * @param partId the partId to set
	 */
	public void setPartId(Long partId) {
		this.partId = partId;
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
	public BarcodePartMapping() {
		super();
		// TODO Auto-generated constructor stub
	}






	/**
	 * @param partId
	 * @param barcodeid
	 * @param updateby
	 */
	public BarcodePartMapping(Long partId, Long barcodeid, String updateby) {
		super();
		this.partId = partId;
		this.barcodeid = barcodeid;
		this.updateby = updateby;
	}
	
	
	
	
	

}
