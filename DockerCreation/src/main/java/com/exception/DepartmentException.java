package com.exception;

public class DepartmentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8306668252934405430L;
	String error;
	public DepartmentException(String message,String error) {
		super(message);
		this.error=error;
	}

}
