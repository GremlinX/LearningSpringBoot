package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

/**
 * "@RestController": This Class is a web resource that is implemented by a REST
 * controller. "@RequestMapping": Names the resource.
 */
@RestController
@RequestMapping(value = "/products") // web site path: localhost:8080/products
public class ProductResource {

	/** This method is a dependency for Service */
	@Autowired // @Autowired means a auto Dependency Injection
	private ProductService service;

	/**
	 * EndPoint method to access users. "@return": ResponseEntity its a specific
	 * SpringBoots type to return web requests. The Generic USER means that the
	 * response type will be a list of users 'List<<Product>>' type" "@GetMapping":
	 * means that this method will be a GET method
	 */
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();

		// .ok means that return a success in the http
		// .body(list) will show the list of users "list" at the body
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // This is indicating that in this endpoint / path i'm accepting and id in the
									// URL
	/**
	 * Spring, to accept this id in the parameter we need to give an annotation called 
	 * "PathVariable" that says that a variable will be given in the URL
	 * and then it will obtain the id in the url and pass to the method argument.
	 * @param id
	 * @return
	 */
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
