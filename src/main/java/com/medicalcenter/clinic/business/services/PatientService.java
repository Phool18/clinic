package com.medicalcenter.clinic.business.services;

import java.time.LocalDate;
import java.util.List;

import com.medicalcenter.clinic.business.entities.Patient;

public interface PatientService {

	public List<Patient> getAllPatients();
	
	public Boolean addPatient(Patient patient);
	
	public LocalDate convertToDate(String date);
	
	public Patient getPatientByDni(String dni);
}
