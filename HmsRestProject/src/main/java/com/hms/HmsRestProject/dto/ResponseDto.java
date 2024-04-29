package com.hms.HmsRestProject.dto;

public class ResponseDto {
	private Object object;
	private boolean isEmpty;
	public ResponseDto(Object object, boolean isEmpty) {
		super();
		this.object = object;
		this.isEmpty = isEmpty;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
}
