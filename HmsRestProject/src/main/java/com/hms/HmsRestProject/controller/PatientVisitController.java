package com.hms.HmsRestProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.HmsRestProject.dto.PatientVisitDto;
import com.hms.HmsRestProject.dto.ResponseDto;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;
import com.hms.HmsRestProject.exceptions.HandleBadRequest;
import com.hms.HmsRestProject.model.PatientVisit;
import com.hms.HmsRestProject.service.PatientVisitService;

@RestController
@RequestMapping("/option")
public class PatientVisitController {

	@Autowired
	private PatientVisitService patientVisitService;

	@GetMapping("/patient-visit-history/{patientId}")
	public ResponseEntity<?> getPatientVisitHistoryById(@PathVariable String patientId)
			throws ResourceNotFoundException {

		List<PatientVisit> visitHistory = patientVisitService.getPatientVisitHistoryById(patientId);

		if (visitHistory != null) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(visitHistory, false), HttpStatus.ACCEPTED);
		} else {
			throw new ResourceNotFoundException("dont have patient visit history for patient id " + patientId);
		}
	}

	@PostMapping("/add-patient-visit-data")
	public ResponseEntity<ResponseDto> registerPatientVisit(@RequestBody PatientVisitDto patientVisitDto) {

		Optional<Object> response = patientVisitService.createPatientVisit(patientVisitDto);
		if (response.isEmpty()) {
//			return new ResponseEntity<ResponseDto>(new ResponseDto(null, true), HttpStatus.NOT_FOUND);
			throw new HandleBadRequest("Patient visit not saved");
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(response.get(), false), HttpStatus.CREATED);
		}
	}

}
