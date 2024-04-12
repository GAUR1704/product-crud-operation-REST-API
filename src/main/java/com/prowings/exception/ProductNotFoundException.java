package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Product not found")

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6041419814129361648L;

	public ProductNotFoundException(int id) {
		
		super("ProductNotFoundException with id = "+id);
	}

	

}
