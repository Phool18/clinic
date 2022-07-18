package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.clinic.business.entities.Appointment;
import com.medicalcenter.clinic.business.entities.Doctor;
import com.medicalcenter.clinic.business.entities.Patient;
import com.medicalcenter.clinic.business.services.AppointmentService;
import com.medicalcenter.clinic.business.services.DoctorService;
import com.medicalcenter.clinic.business.services.PatientService;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(value = "/appointments")
	public ModelAndView viewAppointmentPage() {
		List<Appointment> appointmentList = appointmentService.getAllAppointments();
		List<Doctor> doctorList = doctorService.getAllDoctors();
		List<Patient> patientList = patientService.getAllPatients();
		return new ModelAndView("administrator/appointments", "appointmentList", appointmentList)
				.addObject("doctorList", doctorList)
				.addObject("patientList", patientList);
	}
}
