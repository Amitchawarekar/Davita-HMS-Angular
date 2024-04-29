package com.hms.HmsRestProject.controller;

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

import com.hms.HmsRestProject.dto.PatientRegistrationDto;
import com.hms.HmsRestProject.dto.ResponseDto;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.PatientService;

@RestController
@RequestMapping("/option")
public class PatientController {

	@Autowired
	PatientService patientService;

	@GetMapping("/patient/{id}")
	public ResponseEntity<Master> getPatientById(@PathVariable("id") String id) {
		System.out.println(id);

		Master master = patientService.getPatientById(id);
		return ResponseEntity.ok(master);

	}

	@PostMapping(path = "/patient-registration")
	public ResponseEntity<Object> registerPatient(@RequestBody PatientRegistrationDto patientRegistrationDto) {

		System.out.println(patientRegistrationDto);
		Optional<Object> response = patientService.createPatient(patientRegistrationDto);
		if (response.isEmpty()) {
			return new ResponseEntity<Object>(new ResponseDto(null, true), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(new ResponseDto(response.get(), false), HttpStatus.CREATED);
		}
	}
	


}
