package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;

public interface OrderService {

	Double calculateOrderValue(List<OrderItem> items);

	Set<Product> findProductsById(List<Long> ids);

	Double calculateMultipleOrders(List<List<OrderItem>> orders);

	Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds);

}
