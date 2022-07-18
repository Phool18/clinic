package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping(value = "/addAppointment")
	public ModelAndView addAppointment(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		String message = null;
		String messageType = null;
		
		Appointment appointment = new Appointment();
		appointment.setDate(appointmentService.convertToDate(request.getParameter("date")));
		appointment.setTime(appointmentService.convertToTime(request.getParameter("time")));
		appointment.setDoctor(doctorService.getDoctorByCmp(Integer.parseInt(request.getParameter("doctor_cmp"))));
		appointment.setPatient(patientService.getPatientByDni(request.getParameter("patient_dni")));
		

		if(appointmentService.addAppointment(appointment)) {
			message = "Registrado correctamente";
			messageType = "success";
		}else {
			message = "Seleccione un horario correcto";
			messageType = "error";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("messageType", messageType);
		return new ModelAndView("redirect:/appointments");
	}
}
