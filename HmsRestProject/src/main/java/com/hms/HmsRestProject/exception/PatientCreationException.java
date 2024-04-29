package com.hms.HmsRestProject.exception;

public class PatientCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6765653873682840565L;
	private String message;

	public PatientCreationException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
