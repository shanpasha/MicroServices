package com.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ProductResponse {

	private String productName;
	private int productId;
	private  double price;
	private int quantity;
	
}
