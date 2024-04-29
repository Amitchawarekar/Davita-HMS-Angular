package com.hms.HmsRestProject.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hms.HmsRestProject.dto.EmployeeDTO;
import com.hms.HmsRestProject.dto.ForgotPasswordDTO;
import com.hms.HmsRestProject.dto.LoginRequestDTO;
import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.exceptions.HandleBadRequest;
import com.hms.HmsRestProject.service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginRequestDTO loginRequestDTO)
			throws InvalidCredentialsException {
		System.out.println(loginRequestDTO);
		EmployeeDTO response = loginService.authenticate(loginRequestDTO.getUserName(),
				loginRequestDTO.getPassword());
		System.out.println("Response" + response);
		if (response == null) {
//			return new ResponseEntity<ResponseDto>(new ResponseDto(null, true), HttpStatus.NOT_FOUND);
			throw new InvalidCredentialsException("Please enter valid credentials..!");
		} else {
//			return new ResponseEntity<ResponseDto>(new ResponseDto(response.get(), false), HttpStatus.ACCEPTED);
			return new ResponseEntity<EmployeeDTO>(response, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/forgot-password")
	public ResponseEntity<ForgotPasswordDTO> forgotPassword(@RequestBody ForgotPasswordDTO requestDto)
			throws MessagingException, InvalidCredentialsException {
		String email = requestDto.getUsername();
		String response = loginService.forgotPassword(email);
		if (response == null) {
//				return new ResponseEntity<ForgotPasswordDTO>(HttpStatus.NOT_FOUND);	
			throw new InvalidCredentialsException("Please enter valid credentials..!");
		} else {
			return new ResponseEntity<ForgotPasswordDTO>(HttpStatus.OK);
		}

	}

	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestParam String username, @RequestParam String oldPassword,
			@RequestParam String newPassword) {
		try {
			boolean isPasswordChanged = loginService.changePassword(username, oldPassword, newPassword);
			if (isPasswordChanged) {
				return ResponseEntity.ok("Password changed successfully");
			} else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
				throw new HandleBadRequest("Please enter valid credentials..!");
			}
		} catch (InvalidCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
			throw new InvalidCredentialsException("Unauthorized credentials");
		}
	}
}
