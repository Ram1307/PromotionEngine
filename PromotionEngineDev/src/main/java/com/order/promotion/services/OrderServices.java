package com.order.promotion.services;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.order.promotion.models.Orders;
import com.order.promotion.models.Product;
import com.order.promotion.models.Promotion;

public class OrderServices implements IOrderServices {

	@Override
	public double getFinalPrice(Orders order, List<Promotion> promo) {
		double price = 0.00;
		Map<String, List<Product>> groupData = order.getProducts().stream()
				.collect(Collectors.groupingBy(Product::getProductID));
		
		for (Promotion innerPomo : promo) {
			if (innerPomo.getProductInfo().size() == 1) {
				String productId = innerPomo.getProductInfo().keySet().iterator().next();
				if (groupData.containsKey(productId)) {
					int noOfProduct = groupData.get(productId).size();
					int noOfproductInPromo = innerPomo.getProductInfo().get(productId);
					if (noOfproductInPromo <= noOfProduct) {
						price += (((noOfProduct / noOfproductInPromo) * innerPomo.getPromoPrice())
								+ ((noOfProduct % noOfproductInPromo) * groupData.get(productId).get(0).getPrice()));
					} else {
						price += noOfProduct * groupData.get(productId).get(0).getPrice();
					}
					groupData.remove(productId);
				} else {
					continue;
				}

			} else if (innerPomo.getProductInfo().size() > 1) {
				Set<Integer> data = new HashSet<Integer>();
				for (Entry<String, Integer> groupPromo : innerPomo.getProductInfo().entrySet()) {
					if (groupData.containsKey(groupPromo.getKey())) {
						int divisionValue = groupData.get(groupPromo.getKey()).size() / groupPromo.getValue();
						data.add(groupData.get(groupPromo.getKey()).size() / groupPromo.getValue());
						if (divisionValue == 0)
							break; // As shopping productID count does not match
									// with promo count

					} else {
						data.add(0);
						break; // promo item in not available in checkout
					}
				}
				int lowest = data.iterator().next();
				if(lowest!=0){
					price += lowest * innerPomo.getPromoPrice();
				for (Entry<String, Integer> groupPromo : innerPomo.getProductInfo().entrySet()) {
					price += (groupData.get(groupPromo.getKey()).size() - (groupPromo.getValue() * lowest))
									* groupData.get(groupPromo.getKey()).get(0).getPrice();
					groupData.remove(groupPromo.getKey());
				}
				
				}

			}

		}
		for(Entry<String, List<Product>> tem:groupData.entrySet())
		     price += tem.getValue().stream().mapToDouble(x -> x.getPrice()).sum();
		// }

		return price;
	}

	@Override
	public double getOrginalPrice(Orders order) {

		return order.getProducts().stream().mapToDouble(x -> x.getPrice()).sum();

	}

}
