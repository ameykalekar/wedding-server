package com.main.entity;

import java.util.Date;

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
	
	@Column(name="PASSWORD",nullable=false)
	protected String password;
	
	@Column(name="TYPE")
	protected String type;
	
	@Column(name="PAYMENT_EXPIRY")
	protected Date paymentExpiryDte;
	
	@Column(name="ACTIVE")
	protected String active;
	
	
	public User(){
		super();
		
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getPaymentExpiryDte() {
		return paymentExpiryDte;
	}


	public void setPaymentExpiryDte(Date paymentExpiryDte) {
		this.paymentExpiryDte = paymentExpiryDte;
	}

	
}
