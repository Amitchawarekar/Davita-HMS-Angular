package com.hms.HmsRestProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medication {
	@Id
	private String medicineId;

	@ManyToOne
	@JoinColumn(name = "diseaseCategoryId")
	private DiseaseCategory diseaseCategory;

	@ManyToOne
	@JoinColumn(name = "diagnosisId")
	private Diagnosis diagnosis;

	@Column(name = "MedicineName")
	private String medicineName;

	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medication(String medicineId, DiseaseCategory diseaseCategory, Diagnosis diagnosis, String medicineName) {
		super();
		this.medicineId = medicineId;
		this.diseaseCategory = diseaseCategory;
		this.diagnosis = diagnosis;
		this.medicineName = medicineName;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public DiseaseCategory getDiseaseCategory() {
		return diseaseCategory;
	}

	public void setDiseaseCategory(DiseaseCategory diseaseCategory) {
		this.diseaseCategory = diseaseCategory;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	@Override
	public String toString() {
		return "Medication [medicineId=" + medicineId + ", diseaseCategory=" + diseaseCategory + ", diagnosis="
				+ diagnosis + ", medicineName=" + medicineName + "]";
	}

}
