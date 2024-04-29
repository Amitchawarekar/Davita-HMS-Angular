package com.hms.HmsRestProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.HmsRestProject.model.Diagnosis;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, String>{
	

}
