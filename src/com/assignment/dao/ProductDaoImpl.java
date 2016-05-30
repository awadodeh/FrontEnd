package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.model.Product;

public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long insert(Product product) {
	        Session session = sessionFactory.getCurrentSession();
	        long id = (long) session.save(product);
	        return id;
	}
	
	@Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }


	@Override
	public Product getById(long id) {
		
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, new Long(id));

		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllEntries() {
		Session session = sessionFactory.openSession();
		List<Product> productList = (List<Product>) session.createQuery("FROM " + Product.class.getName()).list();
		return productList;
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Object o = session.get(Product.class, id);
		session.delete(o);

	}
	
	
}
