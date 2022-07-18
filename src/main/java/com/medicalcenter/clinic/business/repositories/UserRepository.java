package com.medicalcenter.clinic.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.clinic.business.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = ?1 AND password = ?2")
	public User login(String email, String password);
	
	public User findByEmail(String email);
	
	public User findById(int id);
}
