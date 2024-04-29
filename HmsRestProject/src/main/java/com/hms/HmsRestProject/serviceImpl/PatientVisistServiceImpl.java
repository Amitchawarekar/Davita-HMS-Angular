package com.hms.HmsRestProject.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.dao.AllergyRepo;
import com.hms.HmsRestProject.dao.AppointmentRepo;
import com.hms.HmsRestProject.dao.BloodPressureRepo;
import com.hms.HmsRestProject.dao.DiagnosisRepo;
import com.hms.HmsRestProject.dao.MasterRepo;
import com.hms.HmsRestProject.dao.MedicationRepo;
import com.hms.HmsRestProject.dao.PatientVisitRepo;
import com.hms.HmsRestProject.dto.PatientVisitDto;
import com.hms.HmsRestProject.exception.ResourceNotFoundException;
import com.hms.HmsRestProject.model.Allergies;
import com.hms.HmsRestProject.model.Appointment;
import com.hms.HmsRestProject.model.BloodPressure;
import com.hms.HmsRestProject.model.Diagnosis;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.model.Medication;
import com.hms.HmsRestProject.model.PatientVisit;
import com.hms.HmsRestProject.service.EmailService;
import com.hms.HmsRestProject.service.PatientVisitService;

import jakarta.transaction.Transactional;

@Service
public class PatientVisistServiceImpl implements PatientVisitService {

	@Autowired
	private PatientVisitRepo patientVisitRepo;

	@Autowired
	private MasterRepo masterRepo;

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private BloodPressureRepo bloodPressureRepo;

	@Autowired
	private DiagnosisRepo diagnosisRepo;

	@Autowired
	private MedicationRepo medicationRepo;

	@Autowired
	private AllergyRepo allergyRepo;

	@Autowired
	private EmailService emailService;

	private String message = null;

	@Override
	public List<PatientVisit> getPatientVisitHistoryById(String patientId) throws ResourceNotFoundException {

		Optional<Master> master = masterRepo.findById(patientId);
		Master patient = master.get();
		List<PatientVisit> visitHistory = patientVisitRepo.getPatientVisitByPatientId(patient.getId());

		return visitHistory;

	}

	@Override
	@Transactional
	public Optional<Object> createPatientVisit(PatientVisitDto patientVisitDto) {
		// Roles role = roleRepo.findById(patientRegistrationDto.getRole()).get();
		Appointment appointment = appointmentRepo.findById(patientVisitDto.getAppointment()).get();
		appointment.setIsVisitCompleted("Yes");
		Master patient = masterRepo.findById(patientVisitDto.getPatient()).get();
		Master physian = masterRepo.findById(patientVisitDto.getPhysician()).get();
		Master nurse = masterRepo.findById(patientVisitDto.getBookedBy()).get();
		BloodPressure bloodPressure = bloodPressureRepo.findById(patientVisitDto.getBloodPressure()).get();
		Diagnosis diagnosis = diagnosisRepo.findById(patientVisitDto.getDiagnosis()).get();
		Medication med = medicationRepo.findById(patientVisitDto.getMedication()).get();
		Allergies all = allergyRepo.findById(patientVisitDto.getAllergies()).get();

		PatientVisit patientVisit = new PatientVisit();
		BeanUtils.copyProperties(patientVisitDto, patientVisit);
		patientVisit.setAppointment(appointment);
		patientVisit.setPatient(patient);
		patientVisit.setPhysician(physian);
		patientVisit.setBookedBy(nurse);
		patientVisit.setBloodPressure(bloodPressure);
		patientVisit.setDiagnosis(diagnosis);
		patientVisit.setMedication(med);
		patientVisit.setAllergies(all);
		// patientVisit.setVisitDate(Date.valueOf(LocalDate.now().toString()));

		if (patientVisit.getAppointment().getIsVisitCompleted().equalsIgnoreCase("Yes")) {
			try {
				sendPrescriptionEmail(patientVisit);
			} catch (MessagingException e) {
				new Exception(e);
			}
			message = Date.valueOf(LocalDate.now()).toString() + "Patient Visit mail sent";
		}

		return Optional.ofNullable(patientVisitRepo.saveAndFlush(patientVisit));

	}

	private void sendPrescriptionEmail(PatientVisit patientVisit) throws MessagingException {
		boolean flag = false;

		String nextVisitDate = "";
		if (patientVisit.getNextVisitDate() == null) {
			nextVisitDate = "Not sugested";
		} else {
			nextVisitDate = patientVisit.getNextVisitDate().toString();
		}

		String subject = "Visit Details - EPrescription";
		String emailBody = "Your EPrescription Listed below - \n" + "Patient Id : " + patientVisit.getPatient().getId()
				+ "\n" + "Full Name : " + patientVisit.getPatient().getFirstName() + " "
				+ patientVisit.getPatient().getLastName() + "\n" + "Date of Birth : "
				+ patientVisit.getPatient().getDateOfBith() + "\n" + "Visit Date : " + patientVisit.getVisitDate()
				+ "\n" + "Height : " + patientVisit.getHeight() + "\n" + "Weight During Visit : "
				+ patientVisit.getWeight() + "\n" + "Diagnosis : " + patientVisit.getDiagnosis().getDescription() + "\n"
				+ "Medication Suggested : " + patientVisit.getMedication().getMedicineName() + "\n" + "Allergies : "
				+ patientVisit.getAllergies().getAllergyName() + "\n" + "Next Visit : " + nextVisitDate
				+ "\nThanks,\nHMS";

		flag = emailService.sendEmail(patientVisit.getPatient().getEmail(), subject, emailBody);
		if (flag) {
			message = Date.valueOf(LocalDate.now()).toString() + "Patient Visit mail send Successfully with Visit Id : "
					+ patientVisit.getVisitId();
//			logger.log(message);
		} else {
			message = Date.valueOf(LocalDate.now()).toString()
					+ "Patient Visit mail not send Successfully with Visit Id : " + patientVisit.getVisitId();
//			logger.log(message);
			throw new MessagingException(
					"Patient Visit mail not send Successfully with Visit Id : " + patientVisit.getVisitId());
		}
	}

}
