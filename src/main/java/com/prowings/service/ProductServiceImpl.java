package com.prowings.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.ProductDao;
import com.prowings.entity.Product;
import com.prowings.exception.InvalidProductException;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public boolean saveProduct(Product product) {
		System.out.println("inside ProductService :: saveProduct()");

		if(validProduct(product))
			
			return productDao.saveProduct(product);
		else
			return false;
	}

	private boolean validProduct(Product product) {

		if(product.getPrice()<= 10000)
			
			return true;
		else
			throw new InvalidProductException("Invalid Product");
	}

	@Override
	public Product getProductById(int id) {
		
		System.out.println("inside ProductService :: getProductById()");
		
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}



}
