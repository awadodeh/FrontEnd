package com.assignment.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.dao.CustomerDao;
import com.assignment.dao.OrderLineDao;
import com.assignment.dao.ProductDao;
import com.assignment.dao.SalesOrderDao;
import com.assignment.model.Customer;
import com.assignment.model.OrderLine;
import com.assignment.model.Product;
import com.assignment.model.SalesOrder;

@Transactional
public class SalesOrderServicesImpl implements  SalesOrderServices{
	
	@Autowired
	SalesOrderDao salesOrderDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderLineDao orderLineDao;
	
	@Override
	public long addSalesOrder (SalesOrder salesOrder) {
		long id = -1;
		if (isValidOrder(salesOrder)) {
			id = salesOrderDao.insert(salesOrder);
			Customer customer = salesOrder.getCustomer();
			customer.setCurrentCredit(customer.getCurrentCredit() + salesOrder.getTotalPrice());
			customerDao.update(customer);
			for (OrderLine orderLine : salesOrder.getOrderLines()) {
				Product product = orderLine.getProduct();
				product.setQuantity(product.getQuantity() - orderLine.getQuantity());
				productDao.update(product);
				orderLine.setSalesOrder(salesOrder);
				orderLineDao.insert(orderLine);
			}
		}
		return id;
	}
	
	public boolean isValidOrder(SalesOrder salesOrder) {
		boolean isValid = true;
		Customer customer;
		List<OrderLine> orderLines;
		
		customer = salesOrder.getCustomer();
		orderLines = salesOrder.getOrderLines();

		if ((customer == null) || (orderLines == null) || (orderLines.size() == 0)) {
			isValid = false;
		} else {
			double sum = 0;
			for (OrderLine orderLine : orderLines) {
				long quantity = orderLine.getQuantity();
				Product product = orderLine.getProduct();
				if((product == null) || (product.getQuantity() < quantity)) {
					isValid = false;
					break;
				}
				sum += quantity * product.getPrice();	
			}
			if (sum <= (customer.getCreditLimit()-customer.getCurrentCredit()))
				salesOrder.setTotalPrice(sum);
			else
				isValid = false;
		}
		
		return isValid;
	}

	@Override
	public SalesOrder getSalesOrder(long id) {
		return salesOrderDao.getById(id);
	}

	@Override
	public List<SalesOrder> getAllSalesOrder() {
		return salesOrderDao.getAllEntries();
	}

	@Override
	public void deleteSalesOrder(long id) {
		salesOrderDao.delete(id);	
	}
	

}
