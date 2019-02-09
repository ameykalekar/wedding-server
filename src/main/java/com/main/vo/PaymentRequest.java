package com.main.vo;

public class PaymentRequest {
	
   private String key="DpGl9K";
   private String txnid;
   private String hash;
   private String amount;
   private String firstname;
   private String  email;
   private String phone;
   private String   productinfo;
   private String  surl= "http://localhost:4200/payment";
   private String  furl= "http://localhost:4200/payment";
   //private String mode= "dropout";
/**
 * @return the key
 */
public String getKey() {
	return key;
}
/**
 * @param key the key to set
 */
public void setKey(String key) {
	this.key = key;
}
/**
 * @return the txnid
 */
public String getTxnid() {
	return txnid;
}
/**
 * @param txnid the txnid to set
 */
public void setTxnid(String txnid) {
	this.txnid = txnid;
}
/**
 * @return the hash
 */
public String getHash() {
	return hash;
}
/**
 * @param hash the hash to set
 */
public void setHash(String hash) {
	this.hash = hash;
}
/**
 * @return the amount
 */
public String getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(String amount) {
	this.amount = amount;
}
/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}
/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}
/**
 * @return the productinfo
 */
public String getProductinfo() {
	return productinfo;
}
/**
 * @param productinfo the productinfo to set
 */
public void setProductinfo(String productinfo) {
	this.productinfo = productinfo;
}
/**
 * @return the surl
 */
public String getSurl() {
	return surl;
}
/**
 * @param surl the surl to set
 */
public void setSurl(String surl) {
	this.surl = surl;
}
/**
 * @return the furl
 */
public String getFurl() {
	return furl;
}
/**
 * @param furl the furl to set
 */
public void setFurl(String furl) {
	this.furl = furl;
}

   
   

}
