package com.main.vo;

import java.util.List;

import com.main.entity.User;

public class LoginVO {

	public String username;
	public String role;
	public List<String> functions;
	public Long companyId;
	private User userinfo;
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getFunctions() {
		return functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	
	
	/**
	 * @return the userinfo
	 */
	public User getUserinfo() {
		return userinfo;
	}
	/**
	 * @param userinfo the userinfo to set
	 */
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginVO [username=" + username + ", role=" + role + ", functions=" + functions + ", companyId="
				+ companyId + ", userinfo=" + userinfo + "]";
	}

	
	


}
