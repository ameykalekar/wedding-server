package com.main.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="T_PRODUCT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends AuditModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	protected Integer id;
	
	@Column(name="PRODUCTNAME")
	protected String productName;
	
	@Column(name="PRODUCTBRAND")
	protected String productBrand;
	
	@Column(name="PRODUCTTYPE")
	protected String productType;
	
	@Column(name="CATEGORY")
	protected String category;
	
	@Column(name="SUBCATEGORY")
	protected String subCategory;
	
	@Column(name="ACTIVE")
	protected String active;
	
	@Column(name="COMPANYID")
	protected String companyid;
	
	@Column(name="COMMENTS")
	protected String comments;
	
	
	
	/**
	 * @param id
	 * @param productName
	 * @param productBrand
	 * @param productType
	 * @param category
	 * @param subCategory
	 * @param active
	 * @param companyid
	 * @param comments
	 */
	public Product(Integer id, String productName, String productBrand, String productType, String category,
			String subCategory, String active, String companyid, String comments) {
		super();
		this.id = id;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productType = productType;
		this.category = category;
		this.subCategory = subCategory;
		this.active = active;
		this.companyid = companyid;
		this.comments = comments;
	}


	/**
	 * 
	 */
	public Product() {
		super();
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/**
	 * @return the productBrand
	 */
	public String getProductBrand() {
		return productBrand;
	}


	/**
	 * @param productBrand the productBrand to set
	 */
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}


	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}


	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}


	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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
	 * @return the companyid
	 */
	public String getCompanyid() {
		return companyid;
	}


	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
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
		return "Product [id=" + id + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productType=" + productType + ", category=" + category + ", subCategory=" + subCategory
				+ ", active=" + active + ", companyid=" + companyid + ", comments=" + comments + "]";
	}


	
	
	
}
