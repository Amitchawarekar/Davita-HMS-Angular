package com.hms.HmsRestProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.HmsRestProject.dto.ResponseDto;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;
import com.hms.HmsRestProject.model.Allergies;
import com.hms.HmsRestProject.model.Diagnosis;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.InboxService;

@CrossOrigin("*")
@RestController
@RequestMapping("/option")
public class InboxController {

	@Autowired
	private InboxService inboxService;

	@GetMapping("/allergy/{allergyId}")
	public ResponseEntity<ResponseDto> getAllergyById(@PathVariable String allergyId) {

		Allergies allergy = inboxService.getAllergyById(allergyId);
		if (allergy != null) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(allergy, false), HttpStatus.CREATED);
		} else {
			throw new ResourceNotFoundException("allergy not found");
		}
	}

	@GetMapping("/allergy-by-deseasecategory/{diseseCategory}")
	public ResponseEntity<ResponseDto> getAllergyByDiseaseCategory(@PathVariable String diseseCategory)
			throws ResourceNotFoundException {

		List<Allergies> allergiesByCtegory = inboxService.getAllergyByCategory(diseseCategory);
		if (allergiesByCtegory != null) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(allergiesByCtegory, false), HttpStatus.CREATED);
		} else {
			throw new ResourceNotFoundException("allergy not found");
		}
	}

	@GetMapping("/get-all-diagnosis")
	public List<Diagnosis> getAllDiagnosis() throws ResourceNotFoundException {

		List<Diagnosis> allDiagnosis = inboxService.getAllDiagnosis();
		if (allDiagnosis != null) {
			return allDiagnosis;
		} else {
			throw new ResourceNotFoundException("diagnosis not found");
		}
	}

	@GetMapping("/nurses/{category}")
	public ResponseEntity<?> getNusreByCategory(@PathVariable("category") String category) {
		Optional<List<Master>> nurses = inboxService.getNusreByCategory(category);
		if (nurses.isEmpty()) {
			throw new ResourceNotFoundException("Nurse not found with category name : " + category);
		} else {
			return new ResponseEntity<Object>(new ResponseDto(nurses.get(), false), HttpStatus.OK);
		}
	}

	@GetMapping("/physicians/{category}")
	public ResponseEntity<?> getPhysicianByCategory(@PathVariable("category") String category) {
		Optional<List<Master>> physician = inboxService.getPhysicianByCategory(category);
		if (physician.isEmpty()) {
			throw new ResourceNotFoundException("Physician not found with category name : " + category);
		} else {
			return new ResponseEntity<Object>(new ResponseDto(physician.get(), false), HttpStatus.OK);
		}
	}
}
