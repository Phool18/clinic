package com.medicalcenter.clinic.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM schedules WHERE doctor_cmp = ?1")
	public List<Schedule> findByDoctor_cmp(int cmp);
	
	@Query(nativeQuery = true, value = "SELECT * FROM schedules WHERE doctor_cmp = ?1 AND day = ?2")
	public Schedule findByCmpAndDia(int cmp, String day);
}
