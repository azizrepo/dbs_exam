package com.dbs.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="product_code",nullable=false)
private	int productCode;
	@Column(name="product_name",nullable=false,length=20)

	private	String productName;
	@Column(name="product_quantity",nullable=false,length=6)

private	int quantity;
public ProductDetails() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "OrderItem [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity + "]";
}
public ProductDetails(int productCode, String productName, int quantity) {
	super();
	this.productCode = productCode;
	this.productName = productName;
	this.quantity = quantity;
}
public int getProductCode() {
	return productCode;
}
public void setProductCode(int productCode) {
	this.productCode = productCode;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
