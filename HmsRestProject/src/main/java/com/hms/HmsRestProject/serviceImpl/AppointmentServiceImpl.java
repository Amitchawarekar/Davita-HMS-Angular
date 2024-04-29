package com.hms.HmsRestProject.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.dao.AppointmentRepo;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.dto.AppointmentDto;
import com.hms.HmsRestProject.model.Appointment;
import com.hms.HmsRestProject.service.AppointmentService;
import com.hms.HmsRestProject.service.EmailService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private MasterRepo masterRepo;

	@Autowired
	private EmailService emailService;

	private String message = "";

	@Override
	public Optional<Appointment> saveAppointment(AppointmentDto appointmentDto) {

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(appointmentDto.getAppointmentId());

		appointment.setPatient(masterRepo.findById(appointmentDto.getPatientId()).get());

		appointment.setNurse(masterRepo.findById(appointmentDto.getNurseId()).get());

		appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
		appointment.setIsVisitCompleted(appointmentDto.getIsVisitCompeted());
		appointment.setScheduled(appointmentDto.getIsScheduled());

		Optional<Appointment> optional = Optional.ofNullable(appointmentRepo.saveAndFlush(appointment));

		// TODO Auto-generated method stub
		return optional;
	}

	@Override
	public Optional<List<Appointment>> getAppointmentsByPhysicianId(String physicianId) {

		return Optional.ofNullable(appointmentRepo.findAppointmentsByPhysicianId(physicianId));

	}

	@Override
	public Optional<List<Appointment>> getAppointmentsByNurseId(String nurseId) {
		System.out.println(nurseId);

		return Optional.ofNullable(appointmentRepo.findAppointmentsByNurseId(nurseId));
	}

	@Override
	public Optional<Appointment> updateAppointmentByNurse(AppointmentDto appointmentDto) {

		Appointment appointment = appointmentRepo.findById(appointmentDto.getAppointmentId()).orElseThrow(
				() -> new RuntimeException("Appointment not found by id - " + appointmentDto.getAppointmentId()));

		appointment.setPhysician(masterRepo.findById(appointmentDto.getPhysicianId()).get());
		appointment.setScheduled(appointmentDto.getIsScheduled());
		if (appointment.isScheduled()) {
			try {
				sendScheduledAppointmentEmail(appointment);
			} catch (MessagingException e) {
				new Exception(e);
			}
		}

		return Optional.ofNullable(appointmentRepo.saveAndFlush(appointment));
	}

	@Override
	public Optional<Appointment> getAppointmentById(String appointmentId) {

		return appointmentRepo.findById(appointmentId);
	}

	public void sendScheduledAppointmentEmail(Appointment appointment) throws MessagingException {
		boolean flag = false;
		String subject = "HMS - Appointment Scheduled";
		String emailBody = "Hello " + appointment.getPatient().getFirstName() + " "
				+ appointment.getPatient().getLastName() + ",\n" + "Your appointment has been scheduled with Physician "
				+ appointment.getPhysician().getFirstName() + " " + appointment.getPhysician().getLastName() + " on "
				+ appointment.getAppointmentDate() + "\n Thanks,\n HMS";

		flag = emailService.sendEmail(appointment.getPatient().getEmail(), subject, emailBody);
		if (flag) {
			message = Date.valueOf(LocalDate.now()).toString()
					+ "Appointment mail send Successfully with Appointment Id : " + appointment.getAppointmentId();
		} else {
			message = Date.valueOf(LocalDate.now()).toString()
					+ "Appointment mail not send Successfully with Appointment Id : " + appointment.getAppointmentId();
			throw new MessagingException(
					"Appointment mail not send Successfully with Appointment Id : " + appointment.getAppointmentId());
		}
	}

}
