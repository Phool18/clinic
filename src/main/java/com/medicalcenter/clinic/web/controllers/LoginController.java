package com.medicalcenter.clinic.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.clinic.business.entities.User;
import com.medicalcenter.clinic.business.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public ModelAndView viewLoginPage() {
		return new ModelAndView("login");
	}
	
	@PostMapping(value = "/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = null;
		
		User user = userService.login(request.getParameter("email"), request.getParameter("password"));
		if(user != null) {
			session.setAttribute("user", user);
			mav =  new ModelAndView("redirect:/home");
		}else {
			mav = new ModelAndView("login", "error", "Correo electrónico o contraseña incorrectos");
		}
		return mav;
	}

}
