package com.hms.HmsRestProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BloodPressureType")
public class BloodPressure {

	@Id
	private String bloodPressureId;
	private String bloodPressureType;

	public String getBloodPressureId() {
		return bloodPressureId;
	}

	public String getBloodPressureType() {
		return bloodPressureType;
	}

	@Override
	public String toString() {
		return "BloodPressure [bloodPressureId=" + bloodPressureId + ", bloodPressureType=" + bloodPressureType + "]";
	}
	

}
