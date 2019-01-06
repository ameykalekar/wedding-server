package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="T_TASKS")
public class Task {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TASKID")
	protected Integer id;
	
	 
	@Column(name = "CHECKLISTID")
	protected Integer checklistid;
	
	@Column(name="DESCRIPTION")
	protected String desc;
	
	@Transient
	private String status;
	
	@Transient
	private String comment;

	
	
	/**
	 * 
	 */
	public Task() {
		super();
	}





	/**
	 * @param id
	 * @param checklistId
	 * @param desc
	 */
	public Task(Integer id, Integer checklistId, String desc) {
		super();
		this.id = id;
		this.checklistid = checklistId;
		this.desc = desc;
	}





	





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
	 * @return the checklistId
	 */
	public Integer getChecklistId() {
		return checklistid;
	}





	/**
	 * @param checklistId the checklistId to set
	 */
	public void setChecklistId(Integer checklistId) {
		this.checklistid = checklistId;
	}





	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}





	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}





	/**
	 * @return the checklistid
	 */
	public Integer getChecklistid() {
		return checklistid;
	}





	/**
	 * @param checklistid the checklistid to set
	 */
	public void setChecklistid(Integer checklistid) {
		this.checklistid = checklistid;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}





	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}





	/**
	 * @param id
	 * @param checklistid
	 * @param desc
	 * @param status
	 * @param comment
	 */
	public Task(Integer id, Integer checklistid, String desc, String status, String comment) {
		super();
		this.id = id;
		this.checklistid = checklistid;
		this.desc = desc;
		this.status = status;
		this.comment = comment;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [id=" + id + ", checklistid=" + checklistid + ", desc=" + desc + ", status=" + status
				+ ", comment=" + comment + "]";
	}





	
}
