package com.assignment.dao;

import java.util.List;

import com.assignment.model.Product;

public interface ProductDao {
	public long insert(Product product);
    public void update(Product product);
	public Product getById(long id);
	public List<Product> getAllEntries();
	public void delete(long id);
}