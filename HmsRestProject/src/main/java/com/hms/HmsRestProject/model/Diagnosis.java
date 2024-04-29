package com.hms.HmsRestProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

	@Id
	@Column(name = "diagnosisId")
	private String diagnosisId;
	@Column(name = "desciption")
	private String description;

	public Diagnosis() {
		// TODO Auto-generated constructor stub
	}

	public String getDiagnosisId() {
		return diagnosisId;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "diagnosisId=" + diagnosisId + ", description=" + description + "]";
	}

}
