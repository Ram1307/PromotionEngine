package com.order.promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.order.promotion.models.Orders;
import com.order.promotion.models.Product;
import com.order.promotion.models.Promotion;
import com.order.promotion.services.OrderServices;
import com.order.promotion.services.PromotionServices;

public class Main {

	public static void main(String[] args) {
		List<Product> products=new ArrayList<Product>();
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		//products.add(new Product("A", 50));
		//products.add(new Product("B", 30));
		/*products.add(new Product("K", 30));
		products.add(new Product("C", 20));
		products.add(new Product("D", 15));
		products.add(new Product("C", 20));*/
		products.add(new Product("D", 15));
		Orders myOrder=new Orders(products)	;

		PromotionServices promoSer=new PromotionServices();
		Map <String,Integer> promo1=new HashMap<>();
		promo1.put("A",3);
		Map <String,Integer> promo2=new HashMap<>();
		promo2.put("B",2);
		Map <String,Integer> promo3=new HashMap<>();
		promo3.put("C",1);
		promo3.put("D",1);
		Map <String,Integer> promo4=new HashMap<>();
		promo4.put("A",2);
		promo4.put("D",1);
		promoSer.addPromotion(new Promotion(1, promo1, 130));
		promoSer.addPromotion(new Promotion(2, promo2, 45));
		promoSer.addPromotion(new Promotion(3, promo3, 30));
		promoSer.addPromotion(new Promotion(4, promo4, 140));
		OrderServices orderSer=new OrderServices();
		System.out.println("Orders ID:"+myOrder.getOrderID()+", "
				+ "Orginal Price:" +orderSer.getOrginalPrice(myOrder)
				+" Final price :"+ orderSer.getFinalPrice(myOrder, promoSer.getPromotionList()));
	}

}
