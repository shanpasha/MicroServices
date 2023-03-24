package com.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductRequest {
	
	
	private String productName;
	private int quantity;
	private double price;

}
