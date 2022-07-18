package com.medicalcenter.clinic.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	public Patient findByDni(String dni);
}
