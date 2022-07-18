package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medicalcenter.clinic.business.entities.Doctor;
import com.medicalcenter.clinic.business.entities.Specialty;
import com.medicalcenter.clinic.business.entities.User;
import com.medicalcenter.clinic.business.services.DoctorService;
import com.medicalcenter.clinic.business.services.SpecialtyService;
import com.medicalcenter.clinic.business.services.UserService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecialtyService specialtyService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/doctors")
	public ModelAndView viewDoctorPage() {
		ModelAndView mav = new ModelAndView("administrator/doctors");
		List<Doctor> doctorList = doctorService.getAllDoctors();
		List<Specialty> specialtyList = specialtyService.getAllSpecialtys();
		mav.addObject("doctorList", doctorList);
		mav.addObject("specialtyList", specialtyList);
		return mav;
	}

	@PostMapping(value = "/addDoctor")
	public ModelAndView addDoctor(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		String message = null;
		String messageType = null;

		if (userService.getUserByEmail(request.getParameter("email")) == null) {
			if (doctorService.getDoctorByCmp(Integer.parseInt(request.getParameter("cmp"))) == null) {
				
				User user = new User();
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setRole("doctor");
				
				Doctor doctor = new Doctor();
				doctor.setCmp(Integer.parseInt(request.getParameter("cmp")));
				doctor.setNames(request.getParameter("names"));
				doctor.setLastnames(request.getParameter("lastnames"));
				doctor.setPhone(request.getParameter("phone"));
				doctor.setSpecialty(specialtyService.getSpecialtyById(Integer.parseInt(request.getParameter("specialty"))));
				doctor.setUser(user);
				
				doctorService.addDoctor(doctor);
				message = "Registrado correctamente";
				messageType = "success";
			} else {
				message = "El cmp ingresado ya existe";
				messageType = "error";
			}
		} else {
			message = "El email ingresado ya existe";
			messageType = "error";
		}

		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("messageType", messageType);
		return new ModelAndView("redirect:/doctors");
	}
}
