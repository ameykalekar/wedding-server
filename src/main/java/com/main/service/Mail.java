package com.main.service;

import java.util.Date;
import java.util.Map;

public class Mail {

	 private String mailFrom;

	 private String mailTo;

	 private String mailCc;

	 private String mailBcc;

	 private String mailSubject;

	 private String mailContent;

	 private String templateName;

	 private String contentType;
	 
	 private String mailPassWord;
	 
	 private Map< String, Object> Values;

	 public Mail() {
	  contentType = "text/html";
	 }

	 public String getContentType() {
	  return contentType;
	 }

	 public void setContentType(String contentType) {
	  this.contentType = contentType;
	 }

	 public String getMailBcc() {
	  return mailBcc;
	 }

	 public String getTemplateName() {
	  return templateName;
	 }

	 public void setTemplateName(String templateName) {
	  this.templateName = templateName;
	 }

	 public void setMailBcc(String mailBcc) {
	  this.mailBcc = mailBcc;
	 }

	 public String getMailCc() {
	  return mailCc;
	 }

	 public void setMailCc(String mailCc) {
	  this.mailCc = mailCc;
	 }

	 public String getMailFrom() {
	  return mailFrom;
	 }

	 public void setMailFrom(String mailFrom) {
	  this.mailFrom = mailFrom;
	 }

	 public String getMailSubject() {
	  return mailSubject;
	 }

	 public void setMailSubject(String mailSubject) {
	  this.mailSubject = mailSubject;
	 }

	 public String getMailTo() {
	  return mailTo;
	 }

	 public void setMailTo(String mailTo) {
	  this.mailTo = mailTo;
	 }

	 public Date getMailSendDate() {
	  return new Date();
	 }

	 public String getMailContent() {
	  return mailContent;
	 }

	 public void setMailContent(String mailContent) {
	  this.mailContent = mailContent;
	 }

	/**
	 * @return the values
	 */
	public Map<String, Object> getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(Map<String, Object> values) {
		Values = values;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Values == null) ? 0 : Values.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((mailBcc == null) ? 0 : mailBcc.hashCode());
		result = prime * result + ((mailCc == null) ? 0 : mailCc.hashCode());
		result = prime * result + ((mailContent == null) ? 0 : mailContent.hashCode());
		result = prime * result + ((mailFrom == null) ? 0 : mailFrom.hashCode());
		result = prime * result + ((mailSubject == null) ? 0 : mailSubject.hashCode());
		result = prime * result + ((mailTo == null) ? 0 : mailTo.hashCode());
		result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
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
		Mail other = (Mail) obj;
		if (Values == null) {
			if (other.Values != null)
				return false;
		} else if (!Values.equals(other.Values))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (mailBcc == null) {
			if (other.mailBcc != null)
				return false;
		} else if (!mailBcc.equals(other.mailBcc))
			return false;
		if (mailCc == null) {
			if (other.mailCc != null)
				return false;
		} else if (!mailCc.equals(other.mailCc))
			return false;
		if (mailContent == null) {
			if (other.mailContent != null)
				return false;
		} else if (!mailContent.equals(other.mailContent))
			return false;
		if (mailFrom == null) {
			if (other.mailFrom != null)
				return false;
		} else if (!mailFrom.equals(other.mailFrom))
			return false;
		if (mailSubject == null) {
			if (other.mailSubject != null)
				return false;
		} else if (!mailSubject.equals(other.mailSubject))
			return false;
		if (mailTo == null) {
			if (other.mailTo != null)
				return false;
		} else if (!mailTo.equals(other.mailTo))
			return false;
		if (templateName == null) {
			if (other.templateName != null)
				return false;
		} else if (!templateName.equals(other.templateName))
			return false;
		return true;
	}

	/**
	 * @return the mailPassWord
	 */
	public String getMailPassWord() {
		return mailPassWord;
	}

	/**
	 * @param mailPassWord the mailPassWord to set
	 */
	public void setMailPassWord(String mailPassWord) {
		this.mailPassWord = mailPassWord;
	}

	

	}