package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCTCHECKLIST")
public class ProductCheckListMapping extends AuditModel {

	
	
	@Id
	@Column(name="PRODUCTID", unique=true,length=100)
	protected String productId;
	
	@Column(name="CHECKLISTID")
	protected String checkListId;


	@Column(name="ACTIVE")
	protected String active;
	
	
	@Column(name="UPDATEBY")
	protected String updateby;
	
	
	
	/**
	 * 
	 */
	public ProductCheckListMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the checkListId
	 */
	public String getCheckListId() {
		return checkListId;
	}

	/**
	 * @param checkListId the checkListId to set
	 */
	public void setCheckListId(String checkListId) {
		this.checkListId = checkListId;
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
	
	
}