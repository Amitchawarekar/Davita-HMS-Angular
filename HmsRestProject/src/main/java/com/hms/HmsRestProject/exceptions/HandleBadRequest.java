package com.hms.HmsRestProject.exceptions;

public class HandleBadRequest extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8529139529787620217L;

	private String message;

	public HandleBadRequest(String message) {
//		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}