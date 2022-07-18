package com.medicalcenter.clinic.business.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@ToString
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private LocalDate time;
	private String observation;
	private String status = "pendiente";
	
	@ManyToOne
	@JoinColumn(name = "doctor_cmp")
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

}
