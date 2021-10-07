package com.order.promotion.services;

import java.util.ArrayList;
import java.util.List;

import com.order.promotion.models.Promotion;

public class PromotionServices implements IPromotionServices {
	
	private static List<Promotion> promotionList=new ArrayList<>();

	@Override
	public void addPromotion(Promotion promo) {
		promotionList.add(promo);
		
	}

	@Override
	public List<Promotion> getPromotionList() {
		return promotionList;
	}

	



}
