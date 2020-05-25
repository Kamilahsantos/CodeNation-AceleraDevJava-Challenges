package br.com.codenation.repository;

import java.util.List;
import java.util.Optional;

import br.com.codenation.model.Product;

public interface ProductRepository {

	
	List<Product> findAll();
	
	List<Product> findByName(String name);
	
	Optional<Product> findById(Long id);
	
}
