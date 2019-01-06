package com.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T_CHECKLIST")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CheckList {

	
	@Id
	@Column(name="CHECKLISTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer checkListId;
	
	@Column(name="CHECKLISTNAME")
	protected String checkListName;
	
	@Column(name="ACTIVE")
	protected String active;
	
	@Column(name="COMPANYID")
	protected String companyId;
	
	@Column(name="COMMENTS")
	protected String comments;

	
	@Transient
	protected List<Task> tasks = new ArrayList<>();
	
	
	
	/**
	 * 
	 */
	public CheckList() {
		super();
	}


public void addTask(Task task)
{
	
	this.tasks.add(task);

}
	



	/**
 * @param checkListId
 * @param checkListName
 * @param active
 * @param companyId
 * @param comments
 * @param tasks
 */
public CheckList(Integer checkListId, String checkListName, String active, String companyId, String comments,
		List<Task> tasks) {
	super();
	this.checkListId = checkListId;
	this.checkListName = checkListName;
	this.active = active;
	this.companyId = companyId;
	this.comments = comments;
	this.tasks = tasks;
}


	/**
	 * @return the checkListId
	 */
	public Integer getCheckListId() {
		return checkListId;
	}



	/**
	 * @param checkListId the checkListId to set
	 */
	public void setCheckListId(Integer checkListId) {
		this.checkListId = checkListId;
	}



	/**
	 * @return the checkListName
	 */
	public String getCheckListName() {
		return checkListName;
	}



	/**
	 * @param checkListName the checkListName to set
	 */
	public void setCheckListName(String checkListName) {
		this.checkListName = checkListName;
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



	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}



	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}



	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}



	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckList [checkListId=" + checkListId + ", checkListName=" + checkListName + ", active=" + active
				+ ", companyId=" + companyId + ", comments=" + comments + ", tasks=" + tasks + "]";
	}

	
	
}
