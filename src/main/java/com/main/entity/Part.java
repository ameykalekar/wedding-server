package com.main.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="T_PART")
public class Part extends AuditModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	protected Integer id;
	
	@Column(name="PARTNAME")
	protected String partName;
	
	@Column(name="PARTBRAND")
	protected String partBrand;
	
	@Column(name="PARTTYPE")
	protected String partType;
	
	@Column(name="CATEGORY")
	protected String category;
	
	@Column(name="SUBCATEGORY")
	protected String subCategory;
	
	
	
	@Column(name="COMPANYID")
	protected Long companyid;
	
	

		
	@Column(name="PRICE")
	protected String price;
	
	@Column(name="COMMENTS")
	protected String comments;

	

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
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return the partBrand
	 */
	public String getPartBrand() {
		return partBrand;
	}

	/**
	 * @param partBrand the partBrand to set
	 */
	public void setPartBrand(String partBrand) {
		this.partBrand = partBrand;
	}

	/**
	 * @return the partType
	 */
	public String getPartType() {
		return partType;
	}

	/**
	 * @param partType the partType to set
	 */
	public void setPartType(String partType) {
		this.partType = partType;
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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
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
	 * @param id
	 * @param partName
	 * @param partBrand
	 * @param partType
	 * @param category
	 * @param subCategory
	 * @param companyid
	 * @param productid
	 * @param price
	 * @param comments
	 */
	public Part(Integer id, String partName, String partBrand, String partType, String category, String subCategory,
			Long companyid,  String price, String comments) {
		super();
		this.id = id;
		this.partName = partName;
		this.partBrand = partBrand;
		this.partType = partType;
		this.category = category;
		this.subCategory = subCategory;
		this.companyid = companyid;
	
		this.price = price;
		this.comments = comments;
	}

	/**
	 * 
	 */
	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
