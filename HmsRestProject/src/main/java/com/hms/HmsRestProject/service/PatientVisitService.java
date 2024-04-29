package com.hms.HmsRestProject.service;

import java.util.List;
import java.util.Optional;

import com.hms.HmsRestProject.dto.PatientVisitDto;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;
import com.hms.HmsRestProject.model.PatientVisit;

public interface PatientVisitService {

	public List<PatientVisit> getPatientVisitHistoryById(String patientId) throws ResourceNotFoundException;

	Optional<Object> createPatientVisit(PatientVisitDto patientVisitDto);

}
