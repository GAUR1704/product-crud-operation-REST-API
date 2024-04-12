package com.prowings.dao;

import com.prowings.entity.Product;

public interface ProductDao {
	
	public boolean saveProduct(Product product);

	public Product getProductById(int id);

}
