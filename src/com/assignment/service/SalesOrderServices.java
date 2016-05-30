package com.assignment.service;

import java.util.List;

import com.assignment.model.SalesOrder;

public interface SalesOrderServices {
	
	public long addSalesOrder (SalesOrder salesOrder);
	public boolean isValidOrder(SalesOrder salesOrder);
	public SalesOrder getSalesOrder(long id);
	public List<SalesOrder> getAllSalesOrder();
	public void deleteSalesOrder(long id);
	
}
