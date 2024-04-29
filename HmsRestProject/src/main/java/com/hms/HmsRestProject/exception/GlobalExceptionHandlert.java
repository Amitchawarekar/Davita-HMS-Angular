package com.hms.HmsRestProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hms.HmsRestProject.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandlert {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleNotFoundException(RuntimeException ex){
		ApiResponse errorData = new ApiResponse();
		errorData.setMessage("Resource Not Found!");
		errorData.setSuccess(false);
		errorData.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity(errorData,HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ApiResponse> handleMethodNotAllowedException(RuntimeException ex){
		ApiResponse errorData = new ApiResponse();
		errorData.setMessage("Bad Request!");
		errorData.setSuccess(false);
		errorData.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity(errorData,HttpStatus.BAD_REQUEST);	
	}
	


}
