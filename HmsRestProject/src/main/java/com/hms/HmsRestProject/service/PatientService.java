package com.hms.HmsRestProject.service;

import java.util.Optional;

import com.hms.HmsRestProject.dto.PatientRegistrationDto;
import com.hms.HmsRestProject.model.Master;

public interface PatientService {

	public Master getPatientById(String id);

	// public Optional<Object> createPatient(Master master);

	public void savePatientDetailsToCSV(Master master);

	public Optional<Object> createPatient(PatientRegistrationDto PatientRegistrationDto);
}
