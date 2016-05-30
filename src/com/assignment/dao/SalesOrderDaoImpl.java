package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.model.SalesOrder;

public class SalesOrderDaoImpl implements SalesOrderDao{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long insert(SalesOrder salesOrder) {
        Session session = sessionFactory.getCurrentSession();
        long id = (long) session.save(salesOrder);
        return id;
		
	}

	@Override
	public SalesOrder getById(long id) {
		
        Session session = sessionFactory.getCurrentSession();
        SalesOrder salesOrder = (SalesOrder) session.get(SalesOrder.class, new Long(id));

		return salesOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalesOrder> getAllEntries() {
		Session session = sessionFactory.openSession();
		List<SalesOrder> salesOrderList = (List<SalesOrder>) session.createQuery("FROM " + SalesOrder.class.getName()).list();
		return salesOrderList;
	}
	
	@Override
	public void delete(long id) {
			Session session = sessionFactory.openSession();
			Object o = session.get(SalesOrder.class, id);
			session.delete(o);
	}
	
	
}