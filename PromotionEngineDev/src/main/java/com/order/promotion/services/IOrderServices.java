package com.order.promotion.services;

import java.util.List;

import com.order.promotion.models.Orders;
import com.order.promotion.models.Promotion;

public interface IOrderServices {
	public double getFinalPrice(Orders order, List<Promotion> promo);
	public double getOrginalPrice(Orders order);

}
