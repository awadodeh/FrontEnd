package com.assignment.dao;

import java.util.List;

import com.assignment.model.SalesOrder;

public interface SalesOrderDao {
	public long insert(SalesOrder salesOrder);
	public SalesOrder getById(long id);
	public List<SalesOrder> getAllEntries();
	public void delete(long id);
}
