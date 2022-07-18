package com.medicalcenter.clinic.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM patients WHERE dni = ?1")
	public Patient validatePatient(String dni);
}
