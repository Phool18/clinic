package com.medicalcenter.clinic.business.services;

import java.sql.Time;
import java.util.List;

import com.medicalcenter.clinic.business.entities.Schedule;

public interface ScheduleService {

	public List<Schedule> getAllSchedules();
	
	public Boolean addSchedule(Schedule schedule);
	
	public Time convertToTime(String time);
}
