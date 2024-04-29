package com.hms.HmsRestProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.dao.AllergyRepo;
import com.hms.HmsRestProject.dao.DiagnosisRepo;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.model.Allergies;
import com.hms.HmsRestProject.model.Diagnosis;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.service.InboxService;

@Service
public class InboxServiceImpl implements InboxService {
	@Autowired
	private AllergyRepo allergyRepo;

	@Autowired
	private DiagnosisRepo diagnosisRepo;

	@Autowired
	private MasterRepo masterRepo;

	private final String nurse = "Nurse";
	private final String physician = "Physician";

	@Override
	public Allergies getAllergyById(String allergyId) {

		Allergies allergy = allergyRepo.findById(allergyId).orElse(null);
		return allergy;
	}

	@Override
	public List<Allergies> getAllergyByCategory(String diseaseCategoryName) {

		List<Allergies> allergySeacheByDeseaseCat = allergyRepo
				.findByDiseaseCategory_diseaseCategoryId(diseaseCategoryName);
		return allergySeacheByDeseaseCat;

	}

	@Override
	public List<Diagnosis> getAllDiagnosis() {
		List<Diagnosis> diagnosisList = diagnosisRepo.findAll();
		return diagnosisList;
	}

	@Override
	public Optional<List<Master>> getNusreByCategory(String category) {

		return Optional.ofNullable(masterRepo.getMasterByCategory(category, nurse));
	}

	@Override
	public Optional<List<Master>> getPhysicianByCategory(String category) {

		return Optional.ofNullable(masterRepo.getMasterByCategory(category, physician));
	}

}
