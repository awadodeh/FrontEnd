package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.dev.frontend.model.Customer;
import com.dev.frontend.model.Product;
import com.dev.frontend.model.SalesOrder;
import com.dev.frontend.panels.ComboBoxItem;
import com.google.gson.Gson;

public class Services 
{
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;
	
	private static String PRODUCT_REST_SERVICE_URL = "http://localhost:8080/assignment/product/";
	private static String CUSTOMER_REST_SERVICE_URL = "http://localhost:8080/assignment/customer/";
	private static String SALES_ORDER_REST_SERVICE_URL = "http://localhost:8080/assignment/salesorder/";
	
	private static Client client = ClientBuilder.newClient();;
	   
	public static Object save(Object object,int objectType)
	{
		long insertedObjectId = -1;
		
		Gson gson = new Gson();
        String input = "";

		switch(objectType){
		case TYPE_CUSTOMER:
			Customer customer= (Customer)object;
	        input = gson.toJson(customer);
	        insertedObjectId = client.target(CUSTOMER_REST_SERVICE_URL)
	 				.path("/")
	 				.request(MediaType.APPLICATION_JSON)
	 				.put(Entity.entity(input, MediaType.APPLICATION_JSON), long.class);
			break;
		case TYPE_PRODUCT:	
			Product product= (Product)object;
	        input = gson.toJson(product);
	        insertedObjectId = client.target(PRODUCT_REST_SERVICE_URL)
	 				.path("/")
	 				.request(MediaType.APPLICATION_JSON)
	 				.put(Entity.entity(input, MediaType.APPLICATION_JSON), long.class);	
			break;
		case TYPE_SALESORDER:
			SalesOrder salesOrder = (SalesOrder)object;
	        input = gson.toJson(salesOrder);
	        insertedObjectId = client.target(SALES_ORDER_REST_SERVICE_URL)
	 				.path("/")
	 				.request(MediaType.APPLICATION_JSON)
	 				.put(Entity.entity(input, MediaType.APPLICATION_JSON), long.class);
	        break;
		}
		
		return readRecordByCode(insertedObjectId+"", objectType);
	}
	
	public static Object readRecordByCode(String code,int objectType)
	{
		Object object;
		object = null;

		switch(objectType){
		case TYPE_CUSTOMER:
			Customer customer= client
	         		.target(CUSTOMER_REST_SERVICE_URL)
	         		.path("/"+code)
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(Customer.class);
			object = customer;	
			break;
		case TYPE_PRODUCT:	
			Product product = client
			         .target(PRODUCT_REST_SERVICE_URL)
			         .path("/"+code)
			         .request(MediaType.APPLICATION_JSON)
			         .get(Product.class);
			object = product;	
			break;
		case TYPE_SALESORDER:
			SalesOrder salesOrder = client
	         		.target(SALES_ORDER_REST_SERVICE_URL)
	         		.path("/"+code)
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(SalesOrder.class);
			object = salesOrder;	
			break;
		}
		
		return object;
	}
	public static boolean deleteRecordByCode(String code,int objectType)
	{
		String destinationUrl = "";
		boolean is_deleted = false;
		switch(objectType){
		case TYPE_CUSTOMER:
			destinationUrl = CUSTOMER_REST_SERVICE_URL;
			break;
		case TYPE_PRODUCT:	
			destinationUrl = PRODUCT_REST_SERVICE_URL;
			break;
		case TYPE_SALESORDER:
			destinationUrl = SALES_ORDER_REST_SERVICE_URL;
			break;
		}
		
		if (destinationUrl.length() != 0)
			is_deleted = client.target(destinationUrl).path("/"+code).request(MediaType.APPLICATION_JSON).delete(boolean.class);;

		return is_deleted;
	}
	
	public static List<Object> listCurrentRecords(int objectType)
	{
		List<Object> objectList;
		objectList = new ArrayList<Object>();

		switch(objectType){
		case TYPE_CUSTOMER:
			List<Customer> customers = client
	         		.target(CUSTOMER_REST_SERVICE_URL)
	         		.path("/")
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(new GenericType<List<Customer>>() {});
			for (Customer customer:customers)
				objectList.add(customer);	
			break;
		case TYPE_PRODUCT:	
			List<Product> products = client
			         .target(PRODUCT_REST_SERVICE_URL)
			         .path("/")
			         .request(MediaType.APPLICATION_JSON)
			         .get(new GenericType<List<Product>>() {});
			for (Product product:products)
				objectList.add(product);	
			break;
		case TYPE_SALESORDER:
			List<SalesOrder> salesOrders = client
	         		.target(SALES_ORDER_REST_SERVICE_URL)
	         		.path("/")
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(new GenericType<List<SalesOrder>>() {});
			for (SalesOrder salesOrder:salesOrders)
				objectList.add(salesOrder);	
			break;
		}
			
		return objectList;
	}
	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) 
	{	

		List<ComboBoxItem> objectList;
		objectList = new ArrayList<ComboBoxItem>();

		switch(objectType){
		case TYPE_CUSTOMER:
			List<Customer> customers = client
	         		.target(CUSTOMER_REST_SERVICE_URL)
	         		.path("/")
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(new GenericType<List<Customer>>() {});
			for (Customer customer:customers)
				objectList.add(new ComboBoxItem(customer.getCode()+"", customer.getName()));	
			break;
		case TYPE_PRODUCT:	
			List<Product> products = client
			         .target(PRODUCT_REST_SERVICE_URL)
			         .path("/")
			         .request(MediaType.APPLICATION_JSON)
			         .get(new GenericType<List<Product>>() {});
			for (Product product:products)
				objectList.add(new ComboBoxItem(product.getCode()+"", product.getDescription()));
			break;
		case TYPE_SALESORDER:
			List<SalesOrder> salesOrders = client
	         		.target(SALES_ORDER_REST_SERVICE_URL)
	         		.path("/")
	         		.request(MediaType.APPLICATION_JSON)
	         		.get(new GenericType<List<SalesOrder>>() {});
			for (SalesOrder salesOrder:salesOrders)
				objectList.add(new ComboBoxItem(salesOrder.getOrderNumber()+"", salesOrder.getTotalPrice()+""));
			break;
		}
			
		return objectList;
	}
	
	public static double getProductPrice(String productCode) {
		Product product = client
		         .target(PRODUCT_REST_SERVICE_URL)
		         .path("/"+productCode)
		         .request(MediaType.APPLICATION_JSON)
		         .get(Product.class);
		return product.getPrice();
	}
}
