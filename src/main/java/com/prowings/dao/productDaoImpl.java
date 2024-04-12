package com.prowings.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.prowings.entity.Product;
import com.prowings.exception.ProductNotFoundException;

@Repository
public class productDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
		
		System.out.println("inside ProductRepository : saveProduct()");

		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			session.save(product);
			txn.commit();
			session.close();
			System.out.println("Product added successfully!!");
			return true;
		} catch (Exception e) {
			System.out.println("error while adding the product to DB!!");
			
			e.printStackTrace();
			
			return false;
		}

	}

	@Override
	public Product getProductById(int id) {
		System.out.println("inside ProductRepository :: getProductById()");

		Session session = null;
		Transaction txn = null;
		Product res = new Product();
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			res = session.get(Product.class, id);
			txn.commit();
		} catch (Exception e) {
			System.out.println("Error while fetching the student!!");
			e.printStackTrace();
			if (txn != null)
				txn.rollback();
			throw e;
		}
		if(res != null)
			return res;
		else
			throw new ProductNotFoundException(id);
	}
}
