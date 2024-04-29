package com.hms.HmsRestProject.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hms.HmsRestProject.dto.EmployeeDTO;
import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/register")
	public Master registerEmployee(@RequestBody EmployeeDTO master) {
		Master m = null;
		try {
			m=adminService.registerEmployee(master.getId(),master.getPassword(),master.getFirstName(),master.getLastName(),master.getDateOfBith(),master.getRoleName(),master.getEmail(),master.getDiseaseCategoryName());
		} catch (InvalidCredentialsException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	@PutMapping("/update")
	public Master updateEmployeePassword(@RequestParam("employeeId") String employeeId, @RequestParam("newPassword") String newPassword) {
	    Master m = null;
	    m = adminService.updateEmployeeDetails(employeeId, newPassword);
	    return m;
	}
	
	@GetMapping("/physicians")
	public List<Master> getAllEmployees() {
		List<Master> m= null;
	    try {
			m= adminService.getAllPhysicians();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m; 
	}
	
	@GetMapping("/nurses")
	public List<Master> getAllNurses() {
		List<Master> m= null;
	    try {
			m= adminService.getAllNurse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m; 
	}
	
	

	

}
