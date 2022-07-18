package com.medicalcenter.clinic.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.clinic.business.entities.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewHome(HttpSession session) {
		ModelAndView mav = null;
		if(session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			if(user.getRole().equals("admin")) {
				mav = new ModelAndView("administrator/home");
			}else {
				mav = new ModelAndView("doctor/home");
			}
		}else {
			mav = new ModelAndView("redirect:/login");
		}
		return mav;
	}
}
