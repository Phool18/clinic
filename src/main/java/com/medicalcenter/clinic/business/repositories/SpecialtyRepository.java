package com.medicalcenter.clinic.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{

	public Specialty findByType(String type);

	@Query(nativeQuery = true, value = "SELECT * FROM specialtys WHERE id = ?1")
	public Specialty getSpecialtyById(int id);
	
}
