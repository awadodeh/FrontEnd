package com.assignment.dao;

import java.util.List;

import com.assignment.model.OrderLine;

public interface OrderLineDao {
	public long insert(OrderLine orderLine);
	public OrderLine getById(long id);
	public List<OrderLine> getAllEntries();
	public void delete(long id);
}