package com.hms.HmsRestProject.service;

import java.util.List;
import java.util.Optional;

import com.hms.HmsRestProject.model.Allergies;
import com.hms.HmsRestProject.model.Diagnosis;
import com.hms.HmsRestProject.model.Master;

public interface InboxService {

	public Allergies getAllergyById(String allergyId);
	
	public List<Allergies> getAllergyByCategory(String diseaseCategoryName);
	
	public List<Diagnosis> getAllDiagnosis();

	public Optional<List<Master>> getNusreByCategory(String category);

	public Optional<List<Master>> getPhysicianByCategory(String category);
}
