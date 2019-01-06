package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User {

	@Id
	@Column(name="USERNAME", unique=true,length=100)
	protected String username;
	
	@Column(name="FIRSTNAME")
	protected String firstname;
	
	@Column(name="LASTNAME")
	protected String lastname;
	
	@Column(name="ADDRESS")
	protected String address;
	
	@Column(name="MOBILENO")
	protected String mobilenumber;
	
	@Column(name="TYPE")
	protected String type;
	
	
	@Column(name="ACTIVE")
	protected String active;
	
	@Column(name="COMPANYID")
	protected Long companyid;
	
	public User(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8){
		super();
		
	}
	
	public User(){
		super();
		
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

}
