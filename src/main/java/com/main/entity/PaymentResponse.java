package com.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PAYMENT")
public class PaymentResponse extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected Integer id;

	@Column(name = "message")
	protected String message;

	@Column(name = "txnStatus")
	protected String txnStatus;
	@Column(name = "txnMessage")
	protected String txnMessage;
	@Column(name = "status")
	protected String status;
	@Column(name = "firstname")
	protected String firstname;
	@Column(name = "amount")
	protected String amount;
	@Column(name = "txnid")
	protected String txnid;
	@Column(name = "hash")
	protected String hash;
	@Column(name = "phone")
	protected String phone;
	@Column(name = "email")
	protected String email;
	@Column(name = "bank_ref_num")
	protected String bank_ref_num;
	@Column(name = "mode")
	protected String mode;
	@Column(name = "error")
	protected String error;
	@Column(name = "error_Message")
	protected String error_Message;
	@Column(name = "paymentId")
	protected String paymentId;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the txnStatus
	 */
	public String getTxnStatus() {
		return txnStatus;
	}
	/**
	 * @param txnStatus the txnStatus to set
	 */
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}
	/**
	 * @return the txnMessage
	 */
	public String getTxnMessage() {
		return txnMessage;
	}
	/**
	 * @param txnMessage the txnMessage to set
	 */
	public void setTxnMessage(String txnMessage) {
		this.txnMessage = txnMessage;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the bank_ref_num
	 */
	public String getBank_ref_num() {
		return bank_ref_num;
	}
	/**
	 * @param bank_ref_num the bank_ref_num to set
	 */
	public void setBank_ref_num(String bank_ref_num) {
		this.bank_ref_num = bank_ref_num;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the error_Message
	 */
	public String getError_Message() {
		return error_Message;
	}
	/**
	 * @param error_Message the error_Message to set
	 */
	public void setError_Message(String error_Message) {
		this.error_Message = error_Message;
	}
	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	
	
}
