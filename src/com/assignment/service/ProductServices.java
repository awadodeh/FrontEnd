package com.assignment.service;

import java.util.List;

import com.assignment.model.Product;

public interface ProductServices {
	
	public long addProduct (Product product);
	public Product getProduct(long id);
	public List<Product> getAllProduct();
	public void deleteProduct(long id);
	
}
