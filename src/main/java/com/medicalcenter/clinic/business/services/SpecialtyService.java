package com.medicalcenter.clinic.business.services;

import java.util.List;

import com.medicalcenter.clinic.business.entities.Specialty;

public interface SpecialtyService {
	
	public List<Specialty> getAllSpecialtys();

	public Specialty getSpecialtyById(int id);
	
	public Boolean addSpecialty(Specialty specialty);
	
	
}
