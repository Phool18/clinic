package com.medicalcenter.clinic.business.services;

import com.medicalcenter.clinic.business.entities.User;

public interface UserService {

	public User login(String email, String password);
	
	public User getUserByEmail(String email);
	
	public Boolean addUser(User user);

	
}
