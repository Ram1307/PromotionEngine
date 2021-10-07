package PromotionEngine.PromotionEngineDev;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.order.promotion.models.Orders;
import com.order.promotion.models.Product;
import com.order.promotion.models.Promotion;
import com.order.promotion.services.OrderServices;
import com.order.promotion.services.PromotionServices;

/**
 * Unit test for simple App.
 */
public class AppTest {
	static PromotionServices promoSer = new PromotionServices();
	static OrderServices orderSer = new OrderServices();

	@Before
	public void setUpClass() {
		Map<String, Integer> promo1 = new HashMap<>();
		promo1.put("A", 3);
		Map<String, Integer> promo2 = new HashMap<>();
		promo2.put("B", 2);
		Map<String, Integer> promo3 = new HashMap<>();
		promo3.put("C", 1);
		promo3.put("D", 1);
		promoSer.addPromotion(new Promotion(1, promo1, 130));
		promoSer.addPromotion(new Promotion(2, promo2, 45));
		promoSer.addPromotion(new Promotion(3, promo3, 30));
	}

	@Test
	public void testScenarioA() throws Exception {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("A", 50));
		products.add(new Product("B", 30));
		products.add(new Product("C", 20));
		Orders myOrder = new Orders(products);
		double expectedResult = 100;
		double result = orderSer.getFinalPrice(myOrder, promoSer.getPromotionList());
		assertEquals(expectedResult, result, 0);
	}

	@Test
	public void testScenarioB() throws Exception {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("C", 20));
		Orders myOrder = new Orders(products);
		double expectedResult = 370;
		double result = orderSer.getFinalPrice(myOrder, promoSer.getPromotionList());
		assertEquals(expectedResult, result, 0);
	}

	@Test
	public void testScenarioC() throws Exception {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("A", 50));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("B", 30));
		products.add(new Product("C", 20));
		products.add(new Product("D", 15));
		Orders myOrder = new Orders(products);
		double expectedResult = 280;
		double result = orderSer.getFinalPrice(myOrder, promoSer.getPromotionList());
		assertEquals(expectedResult, result, 0);
	}
}
