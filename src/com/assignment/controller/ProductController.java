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

import com.assignment.model.Product;
import com.assignment.service.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServices productServices;

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody long addProduct(@RequestBody Product product) {
		long id = -1;
			try{
				id = productServices.addProduct(product);
			} catch (Exception e) {
				System.out.println(e);
			}
			return id;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<Product>();

		try{
			productList = productServices.getAllProduct();
		} catch (Exception e) {
			System.out.println(e);
		}
		return productList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id") long id) {
		Product product = new Product();
		try{
			product = productServices.getProduct(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteProduct(@PathVariable("id") long id) {
		boolean isDeleted = true;
		try{
			productServices.deleteProduct(id);
		} catch (Exception e) {
			isDeleted = false;
			System.out.println(e);
		}
		return isDeleted;
	}	
}	