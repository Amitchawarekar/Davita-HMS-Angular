package com.hms.HmsRestProject.dto;

import java.sql.Date;

public class PatientVisitDto {
	private String visitId;
	private String appointment;
	private String patient;
	private String physician;
	private String bookedBy;
	private Date visitDate;
	private double height;
	private double weight;
	private String bloodPressure;
	private String diagnosis;
	private String medication;
	private String allergies;
	private Date nextVisitDate;
	public PatientVisitDto(String visitId, String appointment, String patient, String physician, String bookedBy,
			Date visitDate, double height, double weight, String bloodPressure, String diagnosis, String medication,
			String allergies, Date nextVisitDate) {
		super();
		this.visitId = visitId;
		this.appointment = appointment;
		this.patient = patient;
		this.physician = physician;
		this.bookedBy = bookedBy;
		this.visitDate=visitDate;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.diagnosis = diagnosis;
		this.medication = medication;
		this.allergies = allergies;
		this.nextVisitDate = nextVisitDate;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getPhysician() {
		return physician;
	}
	public void setPhysician(String physician) {
		this.physician = physician;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public Date getNextVisitDate() {
		return nextVisitDate;
	}
	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	
	
	
}
