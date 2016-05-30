package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Customer;
import com.assignment.service.CustomerServices;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServices customerServices;

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody long addCustomer(@RequestBody Customer customer) {
			long id = -1;
			try{
				id = customerServices.addCustomer(customer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		try{
			customerList = customerServices.getAllCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomer(@PathVariable("id") long id) {
		Customer customer = new Customer();
		try{
			customer = customerServices.getCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteCustomer(@PathVariable("id") long id) {
		boolean isDeleted = true;
		try{
			customerServices.deleteCustomer(id);
		} catch (Exception e) {
			isDeleted = false;
			e.printStackTrace();
		}
		return isDeleted;
	}	
}	