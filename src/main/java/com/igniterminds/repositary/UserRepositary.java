package com.igniterminds.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.igniterminds.models.User;

public interface UserRepositary extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);
//	public User findByLastName(String lastName); 
//	public User findByEmail(String email);
	
}
