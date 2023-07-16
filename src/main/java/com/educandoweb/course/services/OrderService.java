package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

/**
 * "OrderService" needs a dependency for OrderRepository (I)
 * For the needing of creating a "Component" (doubt?) we need to 
 * insert an annotation "@Service". It's basically a "@component" 
 * but semantically different.
 */
@Service
public class OrderService {

	// @Autowired means a auto Dependency Injection
	@Autowired
	private OrderRepository repository; // (I)
	
	/**
	 * Method to find and return every / a list of users found in the database 
	 * @return every / a list of users found in the database
	 */
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
