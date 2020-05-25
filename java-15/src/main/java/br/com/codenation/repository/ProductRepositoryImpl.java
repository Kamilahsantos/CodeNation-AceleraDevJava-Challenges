package br.com.codenation.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.data.ProductsMockedData;
import br.com.codenation.model.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private ProductsMockedData data = ProductsMockedData.getInstance();

	@Override
	public List<Product> findAll() {
		return data.allProducts();
	}

	@Override
	public List<Product> findByName(String name) {
		return data.allProducts().stream().filter(product -> product.getName().equals(name))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Product> findById(Long id) {
		return data.allProducts().stream().filter(product -> product.getId().equals(id)).findAny();
	}

}
