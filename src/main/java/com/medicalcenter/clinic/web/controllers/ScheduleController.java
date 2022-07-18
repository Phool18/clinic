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
import com.medicalcenter.clinic.business.entities.Schedule;
import com.medicalcenter.clinic.business.services.DoctorService;
import com.medicalcenter.clinic.business.services.ScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping(value = "/schedules")
	public ModelAndView viewSchedulePage() {
		ModelAndView mav = new ModelAndView("administrator/schedules");
		List<Schedule> scheduleList = scheduleService.getAllSchedules();
		List<Doctor> doctorList = doctorService.getAllDoctors();
		mav.addObject("scheduleList", scheduleList);
		mav.addObject("doctorList", doctorList);
		return mav;
	}
	
	@PostMapping(value = "/addSchedule")
	public ModelAndView addSchedule(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		String message = null;
		String messageType = null;
		
		Schedule schedule = new Schedule();
		schedule.setDay(request.getParameter("day"));
		schedule.setStart_time(scheduleService.convertToTime(request.getParameter("start_time")));
		schedule.setEnd_time(scheduleService.convertToTime(request.getParameter("end_time")));
		schedule.setDoctor(doctorService.getDoctorByCmp(Integer.parseInt(request.getParameter("doctor_cmp"))));
		
		if(scheduleService.addSchedule(schedule)) {
			message = "Registrado correctamente";
			messageType = "success";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("messageType", messageType);
		return new ModelAndView("redirect:/schedules");
	}
	
}
