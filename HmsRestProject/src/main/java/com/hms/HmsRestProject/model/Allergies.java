package com.hms.HmsRestProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Allergies {
	@Id
	private String allergyId;
	@Column(name = "allergyNames")
	private String allergyName;

	@ManyToOne
	@JoinColumn(name = "diseaseCategoryId")
	private DiseaseCategory diseaseCategory;

	public String getAllergyId() {
		return allergyId;
	}

	public String getAllergyName() {
		return allergyName;
	}

	public DiseaseCategory getDiseaseCategory() {
		return diseaseCategory;
	}

	@Override
	public String toString() {
		return "Allergies [allergyId=" + allergyId + ", allergyName=" + allergyName + ", diseaseCategory="
				+ diseaseCategory + "]";
	}

}
