package com.assignment.dao;

import java.util.List;

import com.assignment.model.Customer;

public interface CustomerDao {
	public long insert(Customer customer);
    public void update(Customer customer);
	public Customer getById(long id) ;
	public List<Customer> getAllEntries();
	public void delete(long id);
}