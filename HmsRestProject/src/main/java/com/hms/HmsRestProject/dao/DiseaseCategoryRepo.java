package com.hms.HmsRestProject.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.DiseaseCategory;
import com.hms.HmsRestProject.model.Master;
@Repository
public interface DiseaseCategoryRepo extends JpaRepository<DiseaseCategory, String>{

	

}
