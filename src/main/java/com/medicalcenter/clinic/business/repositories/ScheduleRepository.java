package com.medicalcenter.clinic.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}
