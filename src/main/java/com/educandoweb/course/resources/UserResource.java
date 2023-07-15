package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

/**
 * "@RestController": This Class is a web resource that is implemented by a REST
 * controller. "@RequestMapping": Names the resource.
 */
@RestController
@RequestMapping(value = "/users") // web site path: localhost:8080/users
public class UserResource {

	/**
	 * EndPoint method to access users. "@return": ResponseEntity its a specific
	 * SpringBoots type to return web requests. The Generic USER means that the
	 * response type will be a User type"
	 * "@GetMapping": means that this method will be a GET method
	 */
	@GetMapping
	public ResponseEntity<User> findAll() {
		// Creates a user for testing
		User u = new User(1L, "Maria", "maria@gmail.com", "123456", "senha123");
		// .ok means that return a success in the http
		// .body(u) will show the user "u" at the body
		return ResponseEntity.ok().body(u);
	}
}
