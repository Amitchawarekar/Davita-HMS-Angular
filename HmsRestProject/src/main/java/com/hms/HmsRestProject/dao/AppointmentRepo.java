package com.hms.HmsRestProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hms.HmsRestProject.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, String> {

	

//	@Transactional
//	@Modifying
	@Query("SELECT a FROM Appointment a WHERE a.nurse.id = :nurseId")
	public List<Appointment> findAppointmentsByNurseId(@Param("nurseId") String nurseId);

	@Query("SELECT a FROM Appointment a WHERE a.physician.id = :physicianId")
	public List<Appointment> findAppointmentsByPhysicianId(@Param("physicianId") String physicianId);
}
