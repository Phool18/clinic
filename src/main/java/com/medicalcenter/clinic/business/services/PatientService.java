package com.medicalcenter.clinic.business.services;

import java.time.LocalDate;
import java.util.List;

import com.medicalcenter.clinic.business.entities.Patient;

public interface PatientService {

	public List<Patient> getAllPatients();
	
	public String addPatient(Patient patient);
	
	public LocalDate convertToDate(String date);
}
