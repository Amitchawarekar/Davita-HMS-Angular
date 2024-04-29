package com.hms.HmsRestProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.PatientVisit;

@Repository
public interface PatientVisitRepo extends JpaRepository<PatientVisit, String>{

	
	 List<PatientVisit> getPatientVisitByPatientId(String patientid);
 
}
