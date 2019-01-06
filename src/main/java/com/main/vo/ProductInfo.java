package com.main.vo;

import com.main.entity.CheckList;
import com.main.entity.Product;

public class ProductInfo {
	String barcodeId;
	Product product;
	CheckList checkList;
	BarcodePart barcodePart;
	/**
	 * @return the barcodeId
	 */
	public String getBarcodeId() {
		return barcodeId;
	}
	/**
	 * @param barcodeId the barcodeId to set
	 */
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
	/**
	 * @return the barcodePart
	 */
	public BarcodePart getBarcodePart() {
		return barcodePart;
	}
	/**
	 * @param barcodePart the barcodePart to set
	 */
	public void setBarcodePart(BarcodePart barcodePart) {
		this.barcodePart = barcodePart;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductInfo [barcodeId=" + barcodeId + ", product=" + product + ", checkList=" + checkList
				+ ", barcodePart=" + barcodePart + "]";
	}

	
	
}
