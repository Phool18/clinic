package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView addPatient(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		String message = null;
		String messageType = null;
		
		Patient patient = new Patient();
		patient.setDni(request.getParameter("dni"));
		patient.setNames(request.getParameter("names"));
		patient.setLastnames(request.getParameter("lastnames"));
		patient.setDate_of_birth(patientService.convertToDate(request.getParameter("date_of_birth")));
		patient.setGender(request.getParameter("gender"));
		patient.setAddress(request.getParameter("address"));
		patient.setPhone(request.getParameter("phone"));

		if(patientService.addPatient(patient)) {
			message = "Registrado correctamente";
			messageType = "success";
		}else {
			message = "El paciente ya existe";
			messageType = "error";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("messageType", messageType);
		return new ModelAndView("redirect:/patients");
	}
}
