package com.exception;

import lombok.Data;

@Data
public class ProductCustomException extends RuntimeException {
	

	
	private String errorCode;

	public ProductCustomException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	
	
}
