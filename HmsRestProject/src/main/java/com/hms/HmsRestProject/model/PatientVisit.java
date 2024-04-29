package com.hms.HmsRestProject.model ;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PatientVisit {

	@Id
	private String visitId;

	@ManyToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Master patient;

	@ManyToOne
	@JoinColumn(name = "physicianId")
	private Master physician;

	@ManyToOne
	@JoinColumn(name = "bookedBy")
	private Master bookedBy;

	private Date visitDate;
	private double height;
	private double weight;

	@ManyToOne
	@JoinColumn(name = "bloodPressureId")
	private BloodPressure bloodPressure;

	@ManyToOne
	@JoinColumn(name = "diagnosisId")
	private Diagnosis diagnosis;

	@ManyToOne
	@JoinColumn(name = "medicineId")
	private Medication medication;

	@ManyToOne
	@JoinColumn(name = "allergyId")
	private Allergies allergies;

	private Date nextVisitDate;

	public PatientVisit() {
		// TODO Auto-generated constructor stub
	}

	public PatientVisit(String visitId, Date visitDate, double height, double weight, Date nextVisitDate) {
		super();
		this.visitId = visitId;
		this.visitDate = visitDate;
		this.height = height;
		this.weight = weight;
		this.nextVisitDate = nextVisitDate;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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

	public Date getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Master getPatient() {
		return patient;
	}

	public void setPatient(Master patient) {
		this.patient = patient;
	}

	public Master getPhysician() {
		return physician;
	}

	public void setPhysician(Master physician) {
		this.physician = physician;
	}

	public Master getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(Master bookedBy) {
		this.bookedBy = bookedBy;
	}

	public BloodPressure getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(BloodPressure bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Allergies getAllergies() {
		return allergies;
	}

	public void setAllergies(Allergies allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "PatientVisit [visitId=" + visitId + ", appointment=" + appointment + ", patient=" + patient
				+ ", physician=" + physician + ", bookedBy=" + bookedBy + ", visitDate=" + visitDate + ", height="
				+ height + ", weight=" + weight + ", bloodPressure=" + bloodPressure + ", diagnosis=" + diagnosis
				+ ", medication=" + medication + ", allergies=" + allergies + ", nextVisitDate=" + nextVisitDate + "]";
	}

}
