package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

/**
 * "ProductService" needs a dependency for ProductRepository (I)
 * For the needing of creating a "Component" (doubt?) we need to 
 * insert an annotation "@Service". It's basically a "@component" 
 * but semantically different.
 */
@Service
public class ProductService {

	// @Autowired means a auto Dependency Injection
	@Autowired
	private ProductRepository repository; // (I)
	
	/**
	 * Method to find and return every / a list of product found in the database 
	 * @return every / a list of product found in the database
	 */
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
