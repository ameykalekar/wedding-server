package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_CUSTOMER_CLIENT")
public class CustomerClient {
	
	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long customerId ;

	@Column(name="CUSTOMER_NAME")
	public String customerName;
	
	@Column(name="DESCRIPTION")
	public String description;

	@Column(name="CONTACT")
	public String contact;
	
	@Override
	public String toString() {
		return "CustomerClient [customerId=" + customerId + ", customerName=" + customerName + ", description="
				+ description + ", contact=" + contact + ", companyId=" + companyId + "]";
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	@Column(name="COMPANY_ID")
	Long companyId;

}
