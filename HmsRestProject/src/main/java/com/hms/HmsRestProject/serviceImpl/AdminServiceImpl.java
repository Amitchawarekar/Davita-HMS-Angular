package com.hms.HmsRestProject.serviceImpl;

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.dao.AdminRepo;
import com.hms.HmsRestProject.dao.DiseaseCategoryRepo;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.dao.RoleRepo;
import com.hms.HmsRestProject.exception.InvalidCredentialsException;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo patientRepo;
	
	@Autowired
	private DiseaseCategoryRepo diseaseCategoryRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	

	@Override
	public Master registerEmployee(String employeeId, String employeePassword, String employeeFirstName,
			String employeeLastName, Date employeeDOB, String employeeRole, String employeeEmail,
			String employeeDiseaseCategory) throws InvalidCredentialsException, MessagingException {
		
		Master master = new Master(employeeId, employeeFirstName, employeeLastName, employeePassword, employeeDOB, employeeEmail);
		master.setRole(roleRepo.findById(Integer.parseInt(employeeRole)).get());
		master.setDiseaseCategory(diseaseCategoryRepo.findById(employeeDiseaseCategory).get());
		patientRepo.save(master);
		
		return master;
	}

	@Override
	public List<Master> getAllPhysicians() throws Exception {
		
		return patientRepo.getAllPhysician();
	}

	@Override
	public List<Master> getAllNurse() throws Exception {
		
		return patientRepo.getAllNurse();
	}

	@Override
	public Master removeEmployeeById(String employeeId) {
		
		Master master = patientRepo.findById(employeeId).get();
		
		patientRepo.deleteById(employeeId);		
		return master;
	}

	@Override
	public Master updateEmployeeDetails(String EmployeeId, String Password) {
		Master master = patientRepo.findById(EmployeeId).get();
		master.setPassword(Password);
		patientRepo.save(master);		
		return master;
	}

}
