package com.assignment.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.dao.CustomerDao;
import com.assignment.model.Customer;

@Transactional
public class CustomerServicesImpl implements  CustomerServices{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public long addCustomer (Customer customer) {
		return customerDao.insert(customer);
		
	}
	
	@Override
	public Customer getCustomer(long id) {
		return customerDao.getById(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllEntries();
	}

	@Override
	public void deleteCustomer(long id) {
		customerDao.delete(id);	
	}
	

}
