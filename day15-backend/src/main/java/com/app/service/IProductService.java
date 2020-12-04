package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {
	// add a method to list all products
	List<Product> getAllProducts();
	
	//add a method to get specific poduct details by it's id
	Product getProductDetails(int productId);
}
