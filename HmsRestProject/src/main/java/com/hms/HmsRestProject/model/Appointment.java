package com.hms.HmsRestProject.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String appointmentId;

//	@ManyToOne(targetEntity = Master.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(name = "nurseId")
	private Master nurse;

//	@ManyToOne(targetEntity = Master.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Master patient;

//	@ManyToOne(targetEntity = Master.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(name = "physicianId")
	private Master physician;
	private Date appointmentDate;
	private boolean isScheduled;
	@Column(name = " IsVistCompleted")
	private String isVisitCompleted;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(String appointmentId, Date appointmentDate, boolean isScheduled, String isVisitCompleted) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.isScheduled = isScheduled;
		this.isVisitCompleted = isVisitCompleted;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	public String getIsVisitCompleted() {
		return isVisitCompleted;
	}

	public Master getNurse() {
		return nurse;
	}

	public void setNurse(Master nurse) {
		this.nurse = nurse;
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

	public void setIsVisitCompleted(String isVisitCompleted) {
		this.isVisitCompleted = isVisitCompleted;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", nurse=" + nurse + ", patient=" + patient
				+ ", physician=" + physician + ", appointmentDate=" + appointmentDate + ", isScheduled=" + isScheduled
				+ ", isVisitCompleted=" + isVisitCompleted + "]";
	}
}
