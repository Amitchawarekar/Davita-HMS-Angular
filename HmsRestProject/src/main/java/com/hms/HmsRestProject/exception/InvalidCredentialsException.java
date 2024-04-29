package com.hms.HmsRestProject.exception;

public class InvalidCredentialsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7409975322401563028L;

	private String message;

	public InvalidCredentialsException(String message) {
//		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
