package com.medicalcenter.clinic.business.services;

import java.util.List;

import com.medicalcenter.clinic.business.entities.Doctor;

public interface DoctorService {

	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorByCmp(int cmp);
	
	public Boolean addDoctor(Doctor doctor);
	
	
}
