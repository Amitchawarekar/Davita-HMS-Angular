package com.hms.HmsRestProject.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.HmsRestProject.dto.AppointmentDto;
import com.hms.HmsRestProject.dto.ResponseDto;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;
import com.hms.HmsRestProject.exceptions.HandleBadRequest;
import com.hms.HmsRestProject.model.Appointment;
import com.hms.HmsRestProject.service.AppointmentService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	private static final Logger logger = Logger.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentService;

//	@Autowired
//	private MessageInfo messageInfo;

//	private String message;

//	@GetMapping("/getAppointmentsAssignedToPhysician/{physicianId}")
//	public ResponseEntity<ResponseDto> getAppointmentsAssignedToPhysician(
//			@PathVariable("physicianId") String physicianId) throws InvalidCredentialsException {
//		List<Appointment> appointmentList = appointmentService.getAppointmentsAssignedToPhysician(physicianId);
//		if (appointmentList.isEmpty()) {
//			throw new InvalidCredentialsException("Not found!");
//		} else {
//			return new ResponseEntity<ResponseDto>(new ResponseDto(appointmentList, true), HttpStatus.OK);
//		}
//	}

	@PostMapping("/")
	public ResponseEntity<?> scheduleAppointment(@Valid @RequestBody AppointmentDto appointmentDTO) {

		Optional<Appointment> savedAppointment = appointmentService.saveAppointment(appointmentDTO);
		if (savedAppointment.isEmpty()) {
			logger.error("Appointment not scheduled");
//			return new ResponseEntity<Object>(new ResponseDto("Appointment not scheduled", true), HttpStatus.NOT_FOUND);
			throw new HandleBadRequest("Appointment not scheduled");
		} else {
			logger.info("Appointment Scheduled successfully");
			return new ResponseEntity<Object>(new ResponseDto(savedAppointment.get(), false), HttpStatus.CREATED);
		}
	}

	@PutMapping("/")
	public ResponseEntity<?> updateAppointmentByNurse(@RequestBody AppointmentDto appointmentDTO) {

		Optional<Appointment> isAppointmentUpdated = appointmentService.updateAppointmentByNurse(appointmentDTO);

		if (isAppointmentUpdated.isEmpty()) {
			logger.error("Appointment not found with appointment id : " + appointmentDTO.getAppointmentId());
//			return new ResponseEntity<Object>(new ResponseDto("Appointment not updated", true), HttpStatus.NOT_FOUND);
			throw new ResourceNotFoundException(
					"Appointment not found with appointment id : " + appointmentDTO.getAppointmentId());
		} else {
			logger.info("Appointment updated with appointment id : " + appointmentDTO.getAppointmentId());
			return new ResponseEntity<Object>(new ResponseDto(isAppointmentUpdated.get(), false), HttpStatus.CREATED);
		}
	}

	@GetMapping("/appointment/{appointmentId}")
	public ResponseEntity<?> getAppointmentById(@PathVariable("appointmentId") String appointmentId) {
//		String firstName = null;
//		int len = firstName.length();
		Optional<Appointment> appointmentById = appointmentService.getAppointmentById(appointmentId);

		if (appointmentById.isEmpty()) {
			logger.error("Appointment not found with appointment id : " + appointmentId);
//			return new ResponseEntity<Object>(new ResponseDto("Appointment not found with id " + appointmentId, true),
//					HttpStatus.NOT_FOUND);
			throw new ResourceNotFoundException("Appointment not found with appointment id : " + appointmentId);
		} else {
			logger.info("Appointment found with appointment id : " + appointmentId);
			return new ResponseEntity<Object>(new ResponseDto(appointmentById.get(), false), HttpStatus.OK);

		}
	}

	@GetMapping("/nurse/{nurseId}")
	public ResponseEntity<?> getAppointmentsByNurseId(@PathVariable("nurseId") String nurseId) {
		List<Appointment> appointmentsByNurseId = appointmentService.getAppointmentsByNurseId(nurseId).get();

		if (appointmentsByNurseId.isEmpty()) {
//			return new ResponseEntity<Object>(new ResponseDto("Appointment not found with nurse id " + nurseId, true),
//					HttpStatus.NOT_FOUND);
			logger.error("Appointment not found with nurse id " + nurseId);
			throw new ResourceNotFoundException("Appointment not found with nurse id " + nurseId);
		} else {
			logger.info("Appointment found with nurse id " + nurseId);
			return new ResponseEntity<Object>(new ResponseDto(appointmentsByNurseId, false), HttpStatus.OK);
		}
	}

	@GetMapping("/physician/{physicianId}")
	public ResponseEntity<?> getAppointmentsByPhysicianId(@PathVariable("physicianId") String physicianId) {
		List<Appointment> appointmentsByPhysicianId = appointmentService.getAppointmentsByPhysicianId(physicianId)
				.get();

//		try {
//			return new ResponseEntity<List<Appointment>>(appointmentsByPhysicianId, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
//		}

		if (appointmentsByPhysicianId.isEmpty()) {
//			return new ResponseEntity<Object>(
//					new ResponseDto("Appointment not found with physician id " + physicianId, true),
//					HttpStatus.NOT_FOUND);
			logger.error("Appointment not found with physician id " + physicianId);
			throw new ResourceNotFoundException("Appointment not found with physician id " + physicianId);
		} else {
			logger.error("Appointment found with physician id " + physicianId);
			return new ResponseEntity<Object>(new ResponseDto(appointmentsByPhysicianId, false), HttpStatus.OK);
		}
	}

}
