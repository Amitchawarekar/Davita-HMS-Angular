package com.hms.HmsRestProject.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8529139529787620217L;

	private String message;

	public ResourceNotFoundException(String message) {
//		super(message);
		this.message = message;

	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
