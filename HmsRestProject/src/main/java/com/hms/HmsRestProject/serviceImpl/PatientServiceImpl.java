package com.hms.HmsRestProject.serviceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.dao.DiseaseCategoryRepo;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.dao.RoleRepo;
import com.hms.HmsRestProject.dto.PatientRegistrationDto;
import com.hms.HmsRestProject.model.DiseaseCategory;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.model.Roles;
import com.hms.HmsRestProject.service.PatientService;
import com.opencsv.CSVWriter;

import jakarta.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private MasterRepo patientRepo;

	@Autowired
	private DiseaseCategoryRepo diseaseCategoryRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Master getPatientById(String id) {
		Master master = patientRepo.findById(id).orElse(null);
//		if (master != null) {
//			String diseasecategory = master.getDiseaseCategory() != null
//					? master.getDiseaseCategory().getDiseaseCategoryName()
//					: null;
//			String roleName = master.getRoles() != null ? master.getRoles().getRoleName() : null;
//			return new MasterDTO(master.getId(), diseasecategory, roleName);
//		} else {
		return master;

	}

	@Override
	@Transactional
	public Optional<Object> createPatient(PatientRegistrationDto patientRegistrationDto) {
	
		Roles role = roleRepo.findById(patientRegistrationDto.getRole()).get();
		DiseaseCategory diseaseCategory = diseaseCategoryRepo.findById(patientRegistrationDto.getDiseaseCategory()).get();
		
		Master newPatient = new Master();
		BeanUtils.copyProperties(patientRegistrationDto, newPatient);
		newPatient.setDiseaseCategory(diseaseCategory);
		newPatient.setRole(role);
		System.out.println(newPatient);
		return Optional.of(patientRepo.saveAndFlush(newPatient));
	}
	
	@Override
	public void savePatientDetailsToCSV(Master master) {
        String patientName = master.getFirstName();
        String path = "/HmsRestProject/src/main/resources/csv";
        String csvFilePath = path + "" + master.getId() + "_" + patientName + ".csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            String[] header = { "Patient Id", "Fistname", "Lastname", "Date of Birth", "Email", "DiseaseCategory" };
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format for DOB
            String dobString = dateFormat.format(master.getDateOfBith());
            String[] data = { master.getId(), master.getFirstName(), master.getLastName(), dobString, master.getEmail(),
                    master.getDiseaseCategory().getDiseaseCategoryName() };
            writer.writeNext(header);
            writer.writeNext(data);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
