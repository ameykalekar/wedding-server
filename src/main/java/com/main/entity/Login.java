package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_LOGIN")
public class Login {

	
	@Id
	@Column(name="USERNAME" ,length = 100)
	protected String userid;
	
	@Column(name="PASSWORD")
	protected String password;


	
	/**
	 * @param username
	 * @param password
	 * @param role
	 * @param companyId
	 * @param active
	 */
	public Login(String username, String password) {
		super();
		this.userid = username;
		this.password = password;
		
	}



	/**
	 * 
	 */
	public Login() {
		super();
	}

	

	/**
	 * @return the username
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param username the username to set
	 */
	public void setUserid(String username) {
		this.userid = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
