package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // This annotation will intercept the exceptions
// that will occur so this object can execute a possible handling.
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	/**
	 * This method will intercept any "ResourceNotFoundException" and will handle it
	 * based on what is inside the scope. This annotation "@ExceptionHandler" is
	 * responsible for intercepting the request that triggered an exception to
	 * execute THIS method. The object type of response is what is inside the angle
	 * brackets, which is "StandardError".
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		// .status() is the http code that i'm defining above.
		// .body() will return the object error "err".
		return ResponseEntity.status(status).body(err);
	}
}
