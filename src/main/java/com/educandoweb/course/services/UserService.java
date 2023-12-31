package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		// orElseThrow method tries to "get (as the get method)" the user
		// if there is no user it will trigger the Exception "ResourceNotFoundException"
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// In case the user try to delete a data that does not exist.
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			// In case there is integrity data violation.
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			// In case the user tries to update a non existent data.
			throw new ResourceNotFoundException(id);
		}
	}

	/**
	 * This method will be responsible for updating my "entity" based on the user
	 * "obj". Basically i'm telling that I don't want to update the rest of the
	 * attributes which are "id" and "password"
	 * 
	 * @param entity
	 * @param obj
	 */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
