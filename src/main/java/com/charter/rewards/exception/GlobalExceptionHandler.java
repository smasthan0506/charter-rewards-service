package com.charter.rewards.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("message", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
