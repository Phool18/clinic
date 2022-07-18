package com.medicalcenter.clinic.business.entities;

import java.sql.Time;

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
@Table(name = "schedules")
@Getter
@Setter
@ToString
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String day;
	private Time start_time;
	private Time end_time;
	private String status = "activo";
	
	@ManyToOne
	@JoinColumn(name = "doctor_cmp")
	private Doctor doctor;
	
}
