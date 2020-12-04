package com.app.custom.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
