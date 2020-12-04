package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.custom.exception.ProductNotFoundException;
import com.app.dao.ProductRepository;
import com.app.pojos.Product;
import com.sun.el.stream.Optional;

@Service
@Transactional //optional since it's by default already added on jpaRepository
public class ProductServiceImpl implements IProductService {
	//dependency
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductDetails(int productId) {
		//invoke the method
		java.util.Optional<Product> optionalProduct = productRepo.findById(productId);
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		//if product is not found :throw custom exception
		throw new ProductNotFoundException("Product Not Found : Invalid ID "+productId);
	}
	

}
