package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/**
 * "UserService" needs a dependency for UserRepository (I) For the needing of
 * creating a "Component" (doubt?) we need to insert an annotation "@Service".
 * It's basically a "@component" but semantically different.
 */
@Service
public class UserService {

	// @Autowired means a auto Dependency Injection
	@Autowired
	private UserRepository repository; // (I)

	/**
	 * Method to find and return every / a list of users found in the database
	 * 
	 * @return every / a list of users found in the database
	 */
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
