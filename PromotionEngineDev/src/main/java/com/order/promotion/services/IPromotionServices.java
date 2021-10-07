package com.order.promotion.services;

import java.util.List;

import com.order.promotion.models.Promotion;

public interface IPromotionServices {
	
	public void addPromotion(Promotion promo);
	public List<Promotion> getPromotionList();
	

}
