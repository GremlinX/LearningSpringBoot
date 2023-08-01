package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

/**
 * "@RestController": This Class is a web resource that is implemented by a REST
 * controller. "@RequestMapping": Names the resource.
 */
@RestController
@RequestMapping(value = "/users") // web site path: localhost:8080/users
public class UserResource {

	/** This method is a dependency for Service */
	@Autowired // @Autowired means a auto Dependency Injection
	private UserService service;

	/**
	 * EndPoint method to access users. "@return": ResponseEntity its a specific
	 * SpringBoots type to return web requests. The Generic USER means that the
	 * response type will be a list of users 'List<<User>>' type" "@GetMapping":
	 * means that this method will be a GET method
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();

		// .ok means that return a success in the http
		// .body(list) will show the list of users "list" at the body
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // This is indicating that in this endpoint / path i'm accepting an id in the
									// URL
	/**
	 * Spring, to accept this id in the parameter we need to give an annotation
	 * called "PathVariable" that says that a variable will be given in the URL and
	 * then it will obtain the id in the url and pass to the method argument.
	 * 
	 * @param id
	 * @return
	 */
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);

		// OBS.2: Ins this example the url will be "/users/id".
		// No further details about it.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// OBS.1: +/- 07:30 .created() method expects an URI object so Spring Boots has
		// a default way
		// to generate this URI that is coded above (OBS.2)
		// When you obtain a HTTP 201, we expect that it has a header called "location"
		// that contains
		// the new path of the new resource that we inserted.
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	/**
	 * This method is responsible for deleting users.
	 * "@DeleteMapping" is a Spring annotation for delete routes.
	 * "@PathVariable" makes the variable, in this case is "id", be recognized as 
	 * a variable for URL.
	 * @param id
	 * @return
	 */
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		// .noContent() return a empty response and the HTTP code is 204.
		return ResponseEntity.noContent().build();
	}
}
