package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_COMPANY")
public class Company extends AuditModel{

	@Id
	@Column(name="COMPANYID", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer companyid;
	
	@Column(name="companyname")
	protected String companyname;
	
	@Column(name="ownername")
	protected String ownername;
	
	@Column(name="ADDRESS")
	protected String address;
	
	@Column(name="contactnumber")
	protected String mobilenumber;
	
	@Column(name="Industrytype")
	protected String type;
	
	
	@Column(name="ACTIVE")
	protected String active;
	
	@Column(name="EMAILID")
	protected String emailid;

	/**
	 * @return the companyid
	 */
	public Integer getCompanyid() {
		return companyid;
	}

	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the ownername
	 */
	public String getOwnername() {
		return ownername;
	}

	/**
	 * @param ownername the ownername to set
	 */
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobilenumber
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * @param mobilenumber the mobilenumber to set
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [companyid=" + companyid + ", companyname=" + companyname + ", ownername=" + ownername
				+ ", address=" + address + ", mobilenumber=" + mobilenumber + ", type=" + type + ", active=" + active
				+ ", emailid=" + emailid + "]";
	}

	
	
	
}