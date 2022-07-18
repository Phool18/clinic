package com.medicalcenter.clinic.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Specialty;
import com.medicalcenter.clinic.business.repositories.SpecialtyRepository;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public List<Specialty> getAllSpecialtys() {
		return specialtyRepository.findAll();
	}

	@Override
	public Boolean addSpecialty(Specialty specialty) {
		if(specialtyRepository.findByType(specialty.getType()) == null) {
			specialtyRepository.save(specialty);
			return true;
		}	
		return false;
	}

	@Override
	public Specialty getSpecialtyById(int id) {
		return specialtyRepository.getSpecialtyById(id);
	}
	
}
