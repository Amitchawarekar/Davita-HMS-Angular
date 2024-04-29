package com.hms.HmsRestProject.serviceImpl;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.authenticate.ValidationModule;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.dto.EmployeeDTO;
import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.EmailService;
import com.hms.HmsRestProject.service.LoginService;

import jakarta.transaction.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MasterRepo masterRepo;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EmployeeDTO employeeDTO;

	// private static FileLogger logger;

	@Override
	@Transactional
	public EmployeeDTO authenticate(String username, String password) throws InvalidCredentialsException {
		// String message;
//		employeeDTO = new EmployeeDTO();
		if (ValidationModule.validateEmail(username) && ValidationModule.validatePassword(password)) {
			Master master = masterRepo.findByEmailAndPassword(username, password);

//	        EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(master.getId());
			employeeDTO.setFirstName(master.getFirstName());
			employeeDTO.setLastName(master.getLastName());
			employeeDTO.setEmail(master.getEmail());
			employeeDTO.setPassword(master.getPassword());
			employeeDTO.setRoleName(master.getRoles().getRoleName());
			if(!master.getRoles().getRoleName().equalsIgnoreCase("Admin")) {
				employeeDTO.setDiseaseCategoryName(master.getDiseaseCategory().getDiseaseCategoryName());
			} else {
				employeeDTO.setDiseaseCategoryName("");
			}
			employeeDTO.setDateOfBith(master.getDateOfBith());
			// message = Date.valueOf(LocalDate.now()).toString() + " Logged in successfully
			// by user " + master;
			// logger.log(message);
			Optional<EmployeeDTO> isNull = Optional.ofNullable(employeeDTO);
			if (isNull.isEmpty()) {
				return isNull.get();
			}
		} else {
//	            message = Date.valueOf(LocalDate.now()).toString() + " Not logged in successfully by user " + username;
//	            logger.log(message);
			throw new InvalidCredentialsException("Not logged in successfully..!");
		}
		return employeeDTO;
	}

	@Override
	@Transactional
	public String forgotPassword(String username) throws MessagingException, InvalidCredentialsException {
		Master master = masterRepo.findByEmail(username);

		if (!master.getPassword().isEmpty()) {
			String emailBody = "Hello " + master.getFirstName() + " " + master.getLastName() + ",\n"
					+ "Recently you requested for a password reset. Please find your password attached: "
					+ master.getPassword() + "\nThanks, \nHMS";
			emailService.sendEmail(username, "HMS - Forgot Password", emailBody);
			return master.getPassword();
		} else {
			throw new InvalidCredentialsException("Email address does not exist");
		}
	}

	@Override
	@Transactional
	public boolean changePassword(String username, String oldPassword, String newPassword)
			throws InvalidCredentialsException {
		// String message = null;
		boolean isPasswordChanged = false;

		if (ValidationModule.validatePassword(oldPassword) && ValidationModule.validatePassword(newPassword)) {
			isPasswordChanged = masterRepo.existsByEmailAndPassword(username, oldPassword);
			if (isPasswordChanged) {
				// message = Date.valueOf(LocalDate.now()).toString() + " Password changed
				// successfully " + username;
				// logger.log(message);
				return isPasswordChanged;
			} else {
				// message = Date.valueOf(LocalDate.now()).toString() + " User does not exist "
				// + username;
				// logger.log(message);
				throw new InvalidCredentialsException("User does not exist " + username);
			}
		} else {
			// message = Date.valueOf(LocalDate.now()).toString() + "Password not changed
			// please enter valid credentials "
			// + username;
			// logger.log(message);
			throw new InvalidCredentialsException("Password not changed please enter valid credentials");
		}
	}

}
