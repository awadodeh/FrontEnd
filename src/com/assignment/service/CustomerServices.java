package com.assignment.service;

import java.util.List;

import com.assignment.model.Customer;

public interface CustomerServices {
	
	public long addCustomer (Customer customer);
	public Customer getCustomer(long id);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(long id);
	
}
