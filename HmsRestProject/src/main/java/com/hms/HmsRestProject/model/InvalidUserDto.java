package com.hms.HmsRestProject.model;

import java.time.LocalDateTime;

public class InvalidUserDto {

	private String userId;
	private LocalDateTime disabledForOneMinute;

	public InvalidUserDto() {
		// TODO Auto-generated constructor stub
	}

	public InvalidUserDto(String userId, LocalDateTime disabledForOneMinute) {
		super();
		this.userId = userId;
		this.disabledForOneMinute = disabledForOneMinute;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getDisabledForOneMinute() {
		return disabledForOneMinute;
	}

	public void setDisabledForOneMinute(LocalDateTime disabledForOneMinute) {
		this.disabledForOneMinute = disabledForOneMinute;
	}

}
