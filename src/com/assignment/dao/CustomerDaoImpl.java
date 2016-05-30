package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long insert(Customer customer){
		Session session = sessionFactory.getCurrentSession();
		long id = (long) session.save(customer);
		return id;
	}
	
	@Override
    public void update(Customer customer){
	    Session session = sessionFactory.getCurrentSession();
	    session.update(customer);
	}

	@Override
	public Customer getById(long id) {
		Customer customer = null;
			Session session = sessionFactory.getCurrentSession();
	        customer = (Customer) session.get(Customer.class, id);
        
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllEntries(){
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customerList = (List<Customer>) session.createQuery("FROM " + Customer.class.getName()).list();
		return customerList;
	}
	
	@Override
	public void delete(long id){
		Session session = sessionFactory.getCurrentSession();
		Object o = session.get(Customer.class, id);
		session.delete(o);
	}
	
	
}