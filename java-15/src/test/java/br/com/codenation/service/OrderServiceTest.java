package br.com.codenation.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;

public class OrderServiceTest {

	private OrderService orderService = new OrderServiceImpl();

	@Test
	public void testCalculateOrderValue() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		assertNotNull(this.orderService.calculateOrderValue(items));
	}

	@Test
	public void testFindProductsById() {
		assertNotNull(this.orderService.findProductsById(Arrays.asList(1l, 2l, 3l, 4l, 5l)).size());
	}

	@Test
	public void testCalculateMultipleOrders() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items2 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items3 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		assertNotNull(this.orderService.calculateMultipleOrders(Arrays.asList(items, items2, items3)));
	}

	@Test
	public void testGroupProducts() {
		Map<Boolean, List<Product>> groupedProducts = this.orderService.groupProductsBySale(Arrays.asList(1l, 2l, 12l));
		assertNotNull(groupedProducts.get(true));
		assertNotNull(groupedProducts.get(false));
	}

}
