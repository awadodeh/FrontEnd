package com.assignment.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "order_line")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderLine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "line_number")
	private long lineNumber;

	@Column(name = "quantity", nullable = false)
	private long quantity;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name = "code")
    private Product product;

	@JsonIgnore
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_number")
    private SalesOrder salesOrder;

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

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}
	
}