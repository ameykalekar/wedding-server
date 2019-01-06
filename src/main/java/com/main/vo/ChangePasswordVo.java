package com.main.vo;

public class ChangePasswordVo {
String username;

String currentpassword;

String newpassword;

String confirmnewpassword;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getCurrentpassword() {
	return currentpassword;
}

public void setCurrentpassword(String currentpassword) {
	this.currentpassword = currentpassword;
}

public String getNewpassword() {
	return newpassword;
}

public void setNewpassword(String newpassword) {
	this.newpassword = newpassword;
}

public String getConfirmnewpassword() {
	return confirmnewpassword;
}

public void setConfirmnewpassword(String confirmnewpassword) {
	this.confirmnewpassword = confirmnewpassword;
}

@Override
public String toString() {
	return "ChangePasswordVo [username=" + username + ", currentpassword=" + currentpassword + ", newpassword="
			+ newpassword + ", confirmnewpassword=" + confirmnewpassword + "]";
}


}
