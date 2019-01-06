package com.main.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportSearchCriteria {
	/*reportType:string;
	username:string;
	startDate:string;
	endDate:string;
	companyid:string;*/
	
	private String reportType;
	private String username;
	private String startDate;
	private String endDate;
	private String companyid;
	private String productBrand;
	private String userType;
	
	
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	public Date getStartDateObj() throws ParseException{
		SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(this.startDate);
	}
	
	public Date getEndDateObj() throws ParseException{
		SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(this.endDate);
	}
	@Override
	public String toString() {
		return "ReportSearchCriteria [reportType=" + reportType + ", username=" + username + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", companyid=" + companyid + ", productBrand=" + productBrand + ", userType="
				+ userType + "]";
	}
}
