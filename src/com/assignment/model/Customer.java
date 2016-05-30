package com.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "code")
	private long code;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phone1", nullable = false)
	private String phone1;
	
	@Column(name = "phone2")
	private String phone2;

	@Column(name = "credit_limit", nullable = false)
	private double creditLimit;

	@Column(name = "current_credit", columnDefinition= "DOUBLE default '0.0'")
	private double currentCredit;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER, cascade={CascadeType.REMOVE})
    private List<SalesOrder> salesOrders;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	
	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public double getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(double currentCredit) {
		this.currentCredit = currentCredit;
	}
	
	public List<SalesOrder> getSalesOrders() {
		return salesOrders;
	}

	public void setSalesOrders(List<SalesOrder> salesOrders) {
		this.salesOrders = salesOrders;
	}	
}