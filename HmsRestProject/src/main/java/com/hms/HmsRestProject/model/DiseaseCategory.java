package com.hms.HmsRestProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DiseaseCategory {

	@Id
	private String diseaseCategoryId;
	private String diseaseCategoryName;

	public String getDiseaseCategoryId() {
		return diseaseCategoryId;
	}

	public String getDiseaseCategoryName() {
		return diseaseCategoryName;
	}

	@Override
	public String toString() {
		return "diseaseCategoryId=" + diseaseCategoryId + ", diseaseCategoryName=" + diseaseCategoryName + "]";
	}

}
