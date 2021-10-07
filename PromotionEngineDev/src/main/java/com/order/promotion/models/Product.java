package com.order.promotion.models;

public class Product {
	private String productID;
	private double price;
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(String productID, double price) {
		super();
		this.productID = productID;
		this.price = price;
	}
	
	

}
