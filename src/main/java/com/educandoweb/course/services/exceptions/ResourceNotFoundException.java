package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Custom Exception. This method is an Exception in case you don't find the "id"
	 * of the Object you're looking for.
	 * 
	 * @param id The id of the object you are looking for
	 */
	public ResourceNotFoundException(Object id) {
		super("Resourse not found. Id " + id);
	}
}
