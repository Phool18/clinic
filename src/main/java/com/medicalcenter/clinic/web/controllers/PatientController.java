package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.clinic.business.entities.Patient;
import com.medicalcenter.clinic.business.services.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/patients")
	public ModelAndView viewPatientPage() {
		List<Patient> patientList = patientService.getAllPatients();
		return new ModelAndView("administrator/patients", "patientList", patientList);
	}

	@PostMapping(value = "/addPatient")
	public ModelAndView addPatient(HttpServletRequest request) {

		Patient patient = new Patient();
		patient.setDni(request.getParameter("dni"));
		patient.setNames(request.getParameter("names"));
		patient.setLastnames(request.getParameter("lastnames"));
		patient.setDate_of_birth(patientService.convertToDate(request.getParameter("date_of_birth")));
		patient.setGender(request.getParameter("gender"));
		patient.setAddress(request.getParameter("address"));
		patient.setPhone(request.getParameter("phone"));

		String message = patientService.addPatient(patient);
		
		return new ModelAndView("redirect:patients", "add", message);
	}
}
