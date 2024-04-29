package com.hms.HmsRestProject.service;

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.model.Master;

public interface AdminService {
	
	public Master registerEmployee(String employeeId,String employeePassword,String employeeFirstName,String employeeLastName,Date employeeDOB,String employeeRole,String employeeEmail,String employeeDiseaseCategory) throws InvalidCredentialsException, MessagingException  ;
	public List<Master> getAllPhysicians() throws Exception;
	public List<Master> getAllNurse() throws Exception;
	public Master removeEmployeeById(String employeeId);
	public Master updateEmployeeDetails(String EmployeeId,String Password);

}
