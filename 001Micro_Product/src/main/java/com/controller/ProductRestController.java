package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.request.ProductRequest;
import com.response.ProductResponse;
import com.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductRestController {

private final	ProductService service;
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Integer id){
		
		ProductResponse productResponse=service.getProduct(id);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
		
}

	@PostMapping("/addProduct")
	public ResponseEntity<Integer> AddProduct(@RequestBody ProductRequest productRequest){
		log.info("AddProduct*******{}",productRequest);
		log.info("AddProduct*******{}",service);
		Integer id=service.addProduct(productRequest);
		return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
		
	}
	
	
	
	
}