package com.medicalcenter.clinic.business.services;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Appointment;
import com.medicalcenter.clinic.business.repositories.AppointmentRepository;
import com.medicalcenter.clinic.business.repositories.ScheduleRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Boolean addAppointment(Appointment appointment) {
		
		String day = appointment.getDate().getDayOfWeek().toString();
	
		switch (day) {
		case "MONDAY":
			day = "Lunes";
			break;
		case "TUESDAY":
			day = "Martes";
			break;
		case "WEDNESDAY":
			day = "Miercoles";
			break;
		case "THURSDAY":
			day = "Jueves";
			break;
		case "FRIDAY":
			day = "Viernes";
			break;
		case "SATURDAY":
			day = "Sabado";
			break;
		default:
			break;
		}
		
		if(scheduleRepository.findByCmpAndDia(appointment.getDoctor().getCmp(), day) != null) {
			if(appointmentRepository.findByDoctorAndDatAndTime(appointment.getDoctor().getCmp(), appointment.getDate(), appointment.getTime()) == null) {
				appointmentRepository.save(appointment);
				return true;
			}
		}
		return false;
	}

	@Override
	public LocalDate convertToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date, formatter);
	}
	
	@Override
	public Time convertToTime(String time) {
		Time newTime = null;
		newTime = Time.valueOf(time += ":00");
		return newTime;
	}

}
