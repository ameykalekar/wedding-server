package com.main.vo;

import com.main.entity.Product;

public class ProductReportVo {

	protected Integer id;
	
	protected String productName;
	
	protected String productBrand;
	
	protected String productType;
	
	protected String category;
	
	protected String subCategory;
	
	protected String companyid;
	
	public ProductReportVo(Product product)
	{
		copy(product);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}


	
	public void copy(Product product){
		this.id = product.getId();
		this.productName = product.getProductName();
		this.productBrand = product.getProductBrand();
		this.productType = product.getProductType();
		this.category = product.getCategory();
		this.subCategory = product.getSubCategory();
		this.companyid = product.getCompanyid();
	}
	
}
