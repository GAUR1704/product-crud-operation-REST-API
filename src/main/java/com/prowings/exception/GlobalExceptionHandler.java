package com.prowings.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prowings.model.MyCustomError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidProductException.class)
	public ResponseEntity<MyCustomError> handleInvalidProductException(HttpServletRequest request, Exception ex){
		
		System.out.println("Inside handleInvalidProductException handler method");
		
		MyCustomError error = new MyCustomError();
		
		error.setMassage(ex.getMessage());
		error.setRootCause("The entered price for product out of range please set the price below 10000 for register the product.");
		error.setStatus(406);
		return new ResponseEntity<MyCustomError>(error, HttpStatus.NOT_ACCEPTABLE);
		
	}
		
		@ExceptionHandler(ProductNotFoundException.class)
		public ResponseEntity<MyCustomError> handleProductNotFoundException(HttpServletRequest request, Exception ex){
			
			System.out.println("Inside handleProductNotFoundException handler method");
			
			MyCustomError error = new MyCustomError();
			
			error.setMassage(ex.getMessage());
			error.setRootCause("The entered product is out of stock, will notify you once it available.");
			error.setStatus(404);
			
			return new ResponseEntity<MyCustomError>(error,HttpStatus.NOT_FOUND);
			
			
			
			
		}
			
	
		
	

}
