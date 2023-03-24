package com.exceptions;

public class UserException extends RuntimeException {
	private static final long serialVersionUID = 4329247650591194977L;
	
	String error;
	public UserException(String message, String error) {
		super(message);
		this.error=error;
		
	}
	
	

}
