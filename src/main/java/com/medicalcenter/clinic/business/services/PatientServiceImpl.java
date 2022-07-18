package com.medicalcenter.clinic.business.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Patient;
import com.medicalcenter.clinic.business.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Boolean addPatient(Patient patient) {
		if(patientRepository.findByDni(patient.getDni()) == null) {
			patientRepository.save(patient);
			return true;
		}
		return false;
	}

	@Override
	public LocalDate convertToDate(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date, formatter);
	}

}
