package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();
	private double DISCOUNT_VALUE=0.8;

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
    return items.stream().filter(product ->productRepository.findById(product.getProductId()).isPresent())
      .mapToDouble(product ->{
        Optional<Product> item = this.productRepository.findById(product.getProductId());
        Double value= item.get().getValue()*product.getQuantity();
        return item.get().getIsSale()?(value*DISCOUNT_VALUE):value;
      }).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream().filter(id->productRepository.findById(id).isPresent())
      .map(id->productRepository.findById(id).get()).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().filter(list->!list.isEmpty()).mapToDouble(list->calculateOrderValue(list)).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().filter(id->id>0 && id!=null).map(id->productRepository.findById(id).get())
      .collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Product::getIsSale));
	}

}
