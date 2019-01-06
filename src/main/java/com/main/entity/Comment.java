package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_COMMENT")
public class Comment extends AuditModel{

	@Id
	@Column(name="COMMENTID", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long commentid;
	
	@Column(name="description")
	protected String desc;
	
	@Column(name="commentedby")
	protected String commentedby;
	
	@Column(name = "ticketid")
	protected String ticketid;
	
	

	
	
	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the commentid
	 */
	public Long getCommentid() {
		return commentid;
	}

	/**
	 * @param commentid the commentid to set
	 */
	public void setCommentid(Long commentid) {
		this.commentid = commentid;
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
	 * @return the commentedby
	 */
	public String getCommentedby() {
		return commentedby;
	}

	/**
	 * @param commentedby the commentedby to set
	 */
	public void setCommentedby(String commentedby) {
		this.commentedby = commentedby;
	}

	/**
	 * @return the ticketid
	 */
	public String getTicketid() {
		return ticketid;
	}

	/**
	 * @param ticketid the ticketid to set
	 */
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentedby == null) ? 0 : commentedby.hashCode());
		result = prime * result + ((commentid == null) ? 0 : commentid.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((ticketid == null) ? 0 : ticketid.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentedby == null) {
			if (other.commentedby != null)
				return false;
		} else if (!commentedby.equals(other.commentedby))
			return false;
		if (commentid == null) {
			if (other.commentid != null)
				return false;
		} else if (!commentid.equals(other.commentid))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (ticketid == null) {
			if (other.ticketid != null)
				return false;
		} else if (!ticketid.equals(other.ticketid))
			return false;
		return true;
	}

	/**
	 * @param commentid
	 * @param desc
	 * @param commentedby
	 * @param ticketid
	 */
	public Comment(Long commentid, String desc, String commentedby, String ticketid) {
		super();
		this.commentid = commentid;
		this.desc = desc;
		this.commentedby = commentedby;
		this.ticketid = ticketid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", desc=" + desc + ", commentedby=" + commentedby + ", ticketid="
				+ ticketid + "]";
	}
	
	
	
	
	


	
	
}