package com.medicalcenter.clinic.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.clinic.business.entities.User;
import com.medicalcenter.clinic.business.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String email, String password) {
		return userRepository.login(email, password);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public Boolean addUser(User user) {
		if(userRepository.findByEmail(user.getEmail()) == null) {
			userRepository.save(user);
			return true;
		}
		return false;
	}
	
}
