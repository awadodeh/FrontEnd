package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.model.OrderLine;

public class OrderLineDaoImpl implements OrderLineDao{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long insert(OrderLine orderLine) {
	        Session session = sessionFactory.getCurrentSession();
			long id = (long) session.save(orderLine);
			return id;
	}

	@Override
	public OrderLine getById(long id) {
		
        Session session = sessionFactory.getCurrentSession();
        OrderLine orderLine = (OrderLine) session.get(OrderLine.class, id);

		return orderLine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> getAllEntries() {
		Session session = sessionFactory.openSession();
		List<OrderLine> orderLineList = (List<OrderLine>) session.createQuery("FROM " + OrderLine.class.getName()).list();
		return orderLineList;
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Object o = session.get(OrderLine.class, id);
		session.delete(o);
	}
	
}
