package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

/**
 * "CategoryService" needs a dependency for CategoryRepository (I)
 * For the needing of creating a "Component" (doubt?) we need to 
 * insert an annotation "@Service". It's basically a "@component" 
 * but semantically different.
 */
@Service
public class CategoryService {

	// @Autowired means a auto Dependency Injection
	@Autowired
	private CategoryRepository repository; // (I)
	
	/**
	 * Method to find and return every / a list of users found in the database 
	 * @return every / a list of users found in the database
	 */
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
