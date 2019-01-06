package com.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.main.service.AuditTicketService;

@Entity
@Table(name="T_TICKET")
@EntityListeners(AuditTicketService.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ticket extends AuditModel{
	
	private static final long serialVersionUID = 21313L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name="CREATEDBY")
	protected String createdBy;
	
	@Column(name="DESCRIPTION")
	protected String description;
	
	@Column(name="DEVICEID")
	protected String deviceId;
		
	@Column(name="DEVICELOACTION")
	protected String deviceLocation;
	
	@Column(name="STATUS")
	protected String status;
	
	@Column(name="ASSIGNED_TO")
	protected String assignedTo;
	
	@Column(name="VISIT_TIME")
	protected String visitTime;

	@Column(name="VISIT_DATE")
	@Temporal(TemporalType.DATE)
	protected Date visitDate;
	
	@Column(name="USER_TYPE")
	protected String type;
	
	@Column(name="UPDATED_BY")
	protected String updatedBy;
	
	@Column(name="COMPANYID")
	protected Long companyid;
	
	@Column(name="ESTIMATE")
	protected Long estimate;
	
	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the deviceLocation
	 */
	public String getDeviceLocation() {
		return deviceLocation;
	}

	/**
	 * @param deviceLocation the deviceLocation to set
	 */
	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}

	/**
	 * @return the companyid
	 */
	public Long getCompanyid() {
		return companyid;
	}

	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}
	
	

	/**
	 * @return the estimate
	 */
	public Long getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(Long estimate) {
		this.estimate = estimate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", createdBy=" + createdBy + ", description=" + description + ", deviceId="
				+ deviceId + ", deviceLocation=" + deviceLocation + ", status=" + status + ", assignedTo=" + assignedTo
				+ ", visitTime=" + visitTime + ", visitDate=" + visitDate + ", type=" + type + ", updatedBy="
				+ updatedBy + ", companyid=" + companyid + ", estimate=" + estimate + "]";
	}
	
	
	
	
}
