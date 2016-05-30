package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.SalesOrder;
import com.assignment.service.SalesOrderServices;

@RestController
@RequestMapping("/salesorder")
public class SalesOrderController {

	@Autowired
	SalesOrderServices salesOrderServices;

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody long addSalesOrder(@RequestBody SalesOrder salesOrder) {
		long id = -1;
			try{
				id = salesOrderServices.addSalesOrder(salesOrder);
			} catch (Exception e) {
				System.out.println(e);
			}
			return id;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<SalesOrder> getAllSalesOrder() {
		List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
		try{
			salesOrderList = salesOrderServices.getAllSalesOrder();
		} catch (Exception e) {
			System.out.println(e);
		}
		return salesOrderList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SalesOrder getSalesOrder(@PathVariable("id") long id) {
		SalesOrder salesOrder = new SalesOrder();;
		try{
			salesOrder = salesOrderServices.getSalesOrder(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return salesOrder;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteSalesOrder(@PathVariable("id") long id) {
		boolean isDeleted = true;
		try{
			salesOrderServices.deleteSalesOrder(id);
		} catch (Exception e) {
			isDeleted = false;
			System.out.println(e);
		}
		return isDeleted;
	}	
}	