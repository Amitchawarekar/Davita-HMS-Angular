package com.hms.HmsRestProject.service;

import java.util.List;
import java.util.Optional;

import com.hms.HmsRestProject.dto.AppointmentDto;
import com.hms.HmsRestProject.model.Appointment;

public interface AppointmentService {

	public Optional<Appointment> saveAppointment(AppointmentDto appointmentDto);  //done
	
	public Optional<Appointment> getAppointmentById(String appointmentId); //done

	public Optional<List<Appointment>> getAppointmentsByPhysicianId(String physicianId);

	public Optional<List<Appointment>> getAppointmentsByNurseId(String nurseId);

	public Optional<Appointment> updateAppointmentByNurse(AppointmentDto appointmentDto);//done

}
