package com.medicalcenter.clinic.business.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "patients")
@Getter
@Setter
@ToString
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dni;
	private String names;
	private String lastnames;
	private String address;
	private LocalDate date_of_birth;
	private String gender;
	private String phone;
	private String status = "activo";	

}
