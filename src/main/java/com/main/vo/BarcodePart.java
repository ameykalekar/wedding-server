package com.main.vo;

import java.util.List;

import com.main.entity.Part;

public class BarcodePart {
	
	String barcode;
	
	List<Part> parts;

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the parts
	 */
	public List<Part> getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/**
	 * @param barcode
	 * @param parts
	 */
	public BarcodePart(String barcode, List<Part> parts) {
		super();
		this.barcode = barcode;
		this.parts = parts;
	}

	/**
	 * 
	 */
	public BarcodePart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
