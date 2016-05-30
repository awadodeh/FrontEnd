package com.dev.frontend.model;
import java.io.Serializable;

public class OrderLine implements Serializable {

	private static final long serialVersionUID = 1L;

	private long lineNumber;

	private long quantity;
	
    private Product product;

	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}