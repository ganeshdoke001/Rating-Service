package com.lcwd.rating.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource is not found of this id");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
