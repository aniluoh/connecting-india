package com.igniterminds.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igniterminds.models.User;

public interface UserRepositary extends JpaRepository<User, Integer>{
	
}
