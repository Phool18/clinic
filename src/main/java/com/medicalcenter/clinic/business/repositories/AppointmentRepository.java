package com.medicalcenter.clinic.business.repositories;

import java.sql.Time;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM appointments WHERE doctor_cmp = ?1 AND date = ?2 AND time = ?3")
	public Appointment findByDoctorAndDatAndTime(int cmp, LocalDate date, Time time);
}
