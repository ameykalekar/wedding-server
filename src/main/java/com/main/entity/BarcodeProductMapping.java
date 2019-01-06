package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_BARCODEPRODUCT")
public class BarcodeProductMapping extends AuditModel {
	

	
	@Column(name="PRODUCTID")
	protected Long productId;
	
	
	@Id
	@Column(name="BARCODEID", unique=true,length=100)
	
	protected String barcodeid;
	
	


	
	
	@Column(name="UPDATEBY")
	protected String updateby;
	
	
	@Column(name="COMPANYID")
	protected Long companyId;






	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}






	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}






	/**
	 * @return the barcodeid
	 */
	public String getBarcodeid() {
		return barcodeid;
	}






	/**
	 * @param barcodeid the barcodeid to set
	 */
	public void setBarcodeid(String barcodeid) {
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
	public BarcodeProductMapping() {
		super();
		// TODO Auto-generated constructor stub
	}






	/**
	 * @param productId
	 * @param barcodeid
	 * @param updateby
	 */
	public BarcodeProductMapping(Long productId, String barcodeid, String updateby) {
		super();
		this.productId = productId;
		this.barcodeid = barcodeid;
		this.updateby = updateby;
	}






	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}






	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}






	
}
