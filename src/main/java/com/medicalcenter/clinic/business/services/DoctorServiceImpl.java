package com.medicalcenter.clinic.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Doctor;
import com.medicalcenter.clinic.business.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorByCmp(int cmp) {
		return doctorRepository.findByCmp(cmp);
	}

	@Override
	public Boolean addDoctor(Doctor doctor) {
		if (doctorRepository.save(doctor) != null) {
			return true;
		}
		return false;
	}
	
}
