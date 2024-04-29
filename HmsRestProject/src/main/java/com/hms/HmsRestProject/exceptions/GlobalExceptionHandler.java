package com.hms.HmsRestProject.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private ErrorMessage errorMessage = new ErrorMessage();

//	public GlobalExceptionHandler(){
//		errorMessage = new ErrorMessage();
//	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception e, WebRequest request) {

		errorMessage.setResponseMessage(e.getLocalizedMessage());
		errorMessage.setStatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorMessage.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<ErrorMessage> handleSpecificException(NullPointerException e, WebRequest request) {

		errorMessage.setResponseMessage(e.getLocalizedMessage());
		errorMessage.setStatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorMessage.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { ResourceNotFoundException.class, InvalidCredentialsException.class, HandleBadRequest.class})
	public ResponseEntity<ErrorMessage> handleCustomException(Exception e, WebRequest request) {

		errorMessage.setResponseMessage(e.getMessage());
		errorMessage.setStatusMessage(HttpStatus.NOT_FOUND.toString());
		errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(value = { ResourceNotFoundException.class})
//	public ResponseEntity<ErrorMessage> handleCustomException(ResourceNotFoundException e, WebRequest request) {
//
//		errorMessage.setResponseMessage(e.getMessage());
//		errorMessage.setStatusMessage(HttpStatus.NOT_FOUND.toString());
//		errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
//		errorMessage.setTimestamp(LocalDateTime.now());
//
//		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
//	}
	
//	@ExceptionHandler(value = {HandleBadRequest.class })
//	public ResponseEntity<ErrorMessage> handleBadRequestException(HandleBadRequest e, WebRequest request) {
//
//		errorMessage.setResponseMessage(e.getMessage());
//		errorMessage.setStatusMessage(HttpStatus.BAD_REQUEST.toString());
//		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		errorMessage.setTimestamp(LocalDateTime.now());
//
//		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
//	}
}
