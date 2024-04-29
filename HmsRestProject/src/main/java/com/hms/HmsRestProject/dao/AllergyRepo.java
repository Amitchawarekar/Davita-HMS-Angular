package com.hms.HmsRestProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.Allergies;
import com.hms.HmsRestProject.model.DiseaseCategory;

@Repository
public interface AllergyRepo extends JpaRepository<Allergies, String> {
	

	//public Allergies getAllergyByIdAndDiseaseCategory(String allergyId, String diseaseCategoryId);

	 List<Allergies> findByDiseaseCategory_diseaseCategoryId(String diseaseCategoryId);

}
