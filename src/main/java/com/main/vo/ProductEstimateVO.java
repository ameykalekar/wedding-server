package com.main.vo;

public class ProductEstimateVO {
 
 private String productname;
 private String partname;
 private String price;
 
 public ProductEstimateVO(String productname,String partname,String price){
 this.productname = productname;
 this.partname = partname;
 this.price=price;
 }
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getPartname() {
	return partname;
}
public void setPartname(String partname) {
	this.partname = partname;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

}
