package com.prowings.service;

import java.util.List;

import com.prowings.entity.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public Product getProductById(int id);

	public List<Product> getAllProducts();
	


}
