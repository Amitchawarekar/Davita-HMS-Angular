package com.hms.HmsRestProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.HmsRestProject.model.Medication;

public interface MedicationRepo extends JpaRepository<Medication, String>{
	//List<Medication> getMedicineByDiseaseCategory(String diseaseCategoryId);
	  List<Medication> findByDiseaseCategory_diseaseCategoryId(String diseaseCategoryId);
	  List<Medication> findByDiagnosis_diagnosisId(String diagnosisId);
}
