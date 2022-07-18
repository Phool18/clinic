package com.medicalcenter.clinic.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.Appointment;
import com.medicalcenter.clinic.business.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

}
