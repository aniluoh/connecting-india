package com.igniterminds.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igniterminds.models.User;

public interface UserRepositary extends JpaRepository<User, Integer>{
	
//	public User findByEmail(String email);
//	public User findByFirstName(String firstName);
//	public User findByLastName(String lastName);
//	public User findByEmail(String email);
	
}
