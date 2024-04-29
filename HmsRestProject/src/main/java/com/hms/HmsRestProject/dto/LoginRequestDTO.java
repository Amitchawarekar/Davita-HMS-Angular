package com.hms.HmsRestProject.dto;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 805442678193416084L;
	
	private String userName;
	private String password;

	public LoginRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginRequestDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDTO [userName=" + userName + ", password=" + password + "]";
	}

}
