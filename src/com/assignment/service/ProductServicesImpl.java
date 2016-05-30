package com.assignment.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.dao.ProductDao;
import com.assignment.model.Product;

@Transactional
public class ProductServicesImpl implements  ProductServices{
	
	@Autowired
	ProductDao productDao;

	@Override
	public long addProduct (Product product) {
		return productDao.insert(product);
		
	}
	
	@Override
	public Product getProduct(long id) {
		return productDao.getById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllEntries();
	}

	@Override
	public void deleteProduct(long id) {
		productDao.delete(id);	
	}
	

}
