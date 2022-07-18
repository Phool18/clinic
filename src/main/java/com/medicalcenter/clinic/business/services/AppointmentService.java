package com.medicalcenter.clinic.business.services;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.medicalcenter.clinic.business.entities.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointments();
	
	public Boolean addAppointment(Appointment appointment);
	
	public LocalDate convertToDate(String date);
	
	public Time convertToTime(String time);
}
