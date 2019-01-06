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
	protected String username;
	
	@Column(name="PASSWORD")
	protected String password;
	
	@Column(name="ROLE")
	protected String role;
	
	@Column(name="COMPANYID")
	protected long companyId;
	
	@Column(name="ACTIVE")
	protected String  active;


	
	/**
	 * @param username
	 * @param password
	 * @param role
	 * @param companyId
	 * @param active
	 */
	public Login(String username, String password, String role, long companyId, String active) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.companyId = companyId;
		this.active = active;
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
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the companyId
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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






	

	
	
}
