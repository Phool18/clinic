package com.medicalcenter.clinic.business.services;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Schedule;
import com.medicalcenter.clinic.business.repositories.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public Boolean addSchedule(Schedule schedule) {
		if (scheduleRepository.save(schedule) != null)
			return true;
		return false;
	}

	@Override
	public Time convertToTime(String time) {
		Time newTime = null;
		newTime = Time.valueOf(time += ":00");
		return newTime;
	}

}
