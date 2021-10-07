package com.order.promotion.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Orders {
	private String orderID;
	private List<Product> products;

	public String getOrderID() {
		return orderID;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Orders(List<Product> products) {
		super();
		this.orderID = generatOrderID();
		this.products = products;
	}

	private String generatOrderID(){
		 Random rand = new Random();
		 SimpleDateFormat dt = new SimpleDateFormat("yyyyymmddhhmmss"); 
		  return dt.format(new Date())+rand.nextInt(1000);
		
	}
}
