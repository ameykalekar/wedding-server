package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_BARCODECHECKLISTTASK")
public class BarcodeCheckListTaskMapping {
	
	
	@Id
	@Column(name="ID", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	
	@Column(name="CHECKLISTID")
	protected Long checkListId;
	
	
	
	@Column(name="BARCODEID")
	protected Long barcodeid;
	
	
	@Column(name="TASKID")
	protected Long taskid;
	
	@Column(name="TASKSTATUS")
	protected String taskstatus;
	
	@Column(name="COMMENTS")
	protected String comments;
	
		
	
	@Column(name="UPDATEBY")
	protected String updateby;

	@Transient
	private CheckList checkList;
	

	
	
	

	/**
	 * @return the checkListId
	 */
	public Long getCheckListId() {
		return checkListId;
	}



	/**
	 * @param checkListId the checkListId to set
	 */
	public void setCheckListId(Long checkListId) {
		this.checkListId = checkListId;
	}



	/**
	 * @return the barcodeid
	 */
	public Long getBarcodeid() {
		return barcodeid;
	}



	/**
	 * @param barcodeid the barcodeid to set
	 */
	public void setBarcodeid(Long barcodeid) {
		this.barcodeid = barcodeid;
	}



	/**
	 * @return the taskid
	 */
	public Long getTaskid() {
		return taskid;
	}



	/**
	 * @param taskid the taskid to set
	 */
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}



	/**
	 * @return the taskstatus
	 */
	public String getTaskstatus() {
		return taskstatus;
	}



	/**
	 * @param taskstatus the taskstatus to set
	 */
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}



	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}



	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}



	/**
	 * @return the updateby
	 */
	public String getUpdateby() {
		return updateby;
	}



	/**
	 * @param updateby the updateby to set
	 */
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}



	/**
	 * 
	 */
	public BarcodeCheckListTaskMapping() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param checkListId
	 * @param barcodeid
	 * @param taskid
	 * @param taskstatus
	 * @param comments
	 * @param updateby
	 */
	public BarcodeCheckListTaskMapping(Long checkListId, Long barcodeid, Long taskid, String taskstatus,
			String comments, String updateby) {
		super();
		this.checkListId = checkListId;
		this.barcodeid = barcodeid;
		this.taskid = taskid;
		this.taskstatus = taskstatus;
		this.comments = comments;
		this.updateby = updateby;
	}



	/**
	 * @return the checkList
	 */
	public CheckList getCheckList() {
		return checkList;
	}



	/**
	 * @param checkList the checkList to set
	 */
	public void setCheckList(CheckList checkList) {
		this.checkList = checkList;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BarcodeCheckListTaskMapping [id=" + id + ", checkListId=" + checkListId + ", barcodeid=" + barcodeid
				+ ", taskid=" + taskid + ", taskstatus=" + taskstatus + ", comments=" + comments + ", updateby="
				+ updateby + ", checkList=" + checkList + "]";
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}







}
