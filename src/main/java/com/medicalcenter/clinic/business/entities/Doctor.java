package com.medicalcenter.clinic.business.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@ToString
public class Doctor {

	@Id
	private int cmp;
	private String names;
	private String lastnames;
	private String phone;
	private String status = "activo";
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "specialty_id")
	private Specialty specialty;

}
