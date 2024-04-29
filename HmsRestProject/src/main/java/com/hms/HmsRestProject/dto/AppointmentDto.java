package com.hms.HmsRestProject.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;

public class AppointmentDto {

	private String appointmentId;

	@NotNull(message = "Please enter patient Id")
	private String patientId;
	@NotNull(message = "Please enter nurse Id")
	private String nurseId;
	private String physicianId;
	private Date appointmentDate;
	@NotNull(message = "Please enter visit status is completed or not")
	private String isVisitCompeted;
	@NotNull(message = "Please enter status for appointment is scheduled")
	private boolean isScheduled;

	public AppointmentDto() {
		super();
	}

	public AppointmentDto(String appointmentId, String patientId, String nurseId, String physicianId,
			Date appointmentDate, String isVisitCompeted, boolean isScheduled) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.nurseId = nurseId;
		this.physicianId = physicianId;
		this.appointmentDate = appointmentDate;
		this.isVisitCompeted = isVisitCompeted;
		this.isScheduled = isScheduled;
	}

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
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

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getIsVisitCompeted() {
		return isVisitCompeted;
	}

	public void setIsVisitCompeted(String isVisitCompeted) {
		this.isVisitCompeted = isVisitCompeted;
	}

	public boolean getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	@Override
	public String toString() {
		return "AppointmentDto [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", patientId=" + patientId + ", nurseId=" + nurseId + ", isVisitCompeted=" + isVisitCompeted
				+ ", isScheduled=" + isScheduled + "]";
	}

}
