package com.medicalcenter.clinic.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medicalcenter.clinic.business.entities.Specialty;
import com.medicalcenter.clinic.business.services.SpecialtyService;

@Controller
public class SpecialtyController {

	@Autowired
	private SpecialtyService specialtyService;

	@GetMapping(value = "/specialtys")
	public ModelAndView viewSpecialtyPage() {
		List<Specialty> specialtyList = specialtyService.getAllSpecialtys();
		return new ModelAndView("administrator/specialtys", "specialtyList", specialtyList);
	}

	@PostMapping(value = "/addSpecialty")
	public ModelAndView addSpecialty(@ModelAttribute Specialty specialty, RedirectAttributes redirectAttributes) {
		String message = null;
		String messageType = null;
		try {
			if (specialtyService.addSpecialty(specialty)) {
				message = "Registrado correctamente";
				messageType = "success";
			} else {
				message = "La especialidad ya existe";
				messageType = "error";
			}
		} catch (Exception e) {
			return new ModelAndView("redirect:/specialtys");
		}
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("messageType", messageType);
		return new ModelAndView("redirect:/specialtys");
	}
}
