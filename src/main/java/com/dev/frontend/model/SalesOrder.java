package com.dev.frontend.model;
import java.io.Serializable;
import java.util.List;

public class SalesOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private long orderNumber;

	private double totalPrice;
	
    private Customer customer;

    private List<OrderLine> orderLines;

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
