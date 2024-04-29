package com.hms.HmsRestProject.service;

import java.util.Optional;

import javax.mail.MessagingException;

import com.hms.HmsRestProject.dto.EmployeeDTO;
import com.hms.HmsRestProject.exception.InvalidCredentialsException;

public interface LoginService {

	 public EmployeeDTO authenticate(String username, String password) throws InvalidCredentialsException;
	 public String forgotPassword(String username) throws MessagingException, InvalidCredentialsException;
	 public boolean changePassword(String username, String oldPassword, String newPassword) throws InvalidCredentialsException;
}
