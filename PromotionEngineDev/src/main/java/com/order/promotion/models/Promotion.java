package com.order.promotion.models;

import java.util.Map;

public class Promotion {
	private int promotionID;
	private Map<String, Integer> productInfo;
	private double promoPrice;

	public int getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}

	public Map<String, Integer> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Map<String, Integer> productInfo) {
		this.productInfo = productInfo;
	}

	public double getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	public Promotion(int promotionID, Map<String, Integer> productInfo, double promoPrice) {
		super();
		this.promotionID = promotionID;
		this.productInfo = productInfo;
		this.promoPrice = promoPrice;
	}

}
