package com.service;

import com.request.ProductRequest;
import com.response.ProductResponse;

public interface ProductService {
	
	public Integer addProduct(ProductRequest product);
	public void deleteProduct(Integer id);
	public ProductResponse getProduct(Integer id);
	public void reduceQuantity(Integer Quantity, Integer id);	
	

}
