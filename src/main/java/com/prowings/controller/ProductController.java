package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Product;
import com.prowings.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		System.out.println("Request received to add the product to DB!!");
		System.out.println("Incoming product object : " + product);

		boolean res = productService.saveProduct(product);

		if (res)
			return new ResponseEntity<String>("Product added successfully!!!", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>("Error while adding the Product!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable int id){
		
		System.out.println("Request received to get product by id :" + id + " from database");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("my header", "myHeaderValue");
		headers.add("aaaa", "bbbb");
		
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
		
		
	}
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		System.out.println("Request received to get all product from database");
		
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
		
	}

}
