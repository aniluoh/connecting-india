package com.igniterminds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.igniterminds.models.User;
import com.igniterminds.repositary.UserRepositary;

@RestController
public class UserController {
	
	@Autowired
	UserRepositary userRepo;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFistName(user.getFistName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
		User createdUsed = userRepo.save(newUser);
		
		return createdUsed;
	}
		
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable("userId")Integer id) throws Exception {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new Exception("User not exists in database with user id : "+id);
//		return null;
	}
	
	@PutMapping("/users/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable Integer userId ) throws Exception {
		
		Optional<User> findUser = userRepo.findById(userId);
		
		if(findUser.isEmpty()) {
			throw new Exception("There is no such user present in the system. Kindly provide correct user.");			
		}
		
		User oldUser = findUser.get();
		
		
		if(user.getFistName()!=null) {
			oldUser.setFistName(user.getFistName());
		}
		
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		
		if(user.getPassword()!=null) {
			oldUser.setPassword(user.getPassword());
		}
		
		User updatedUser = userRepo.save(oldUser);
//		User userUpdate = userRepo.
		
		/*
		 * User user2 = new User(2, "Annu", "Chaurasiya", "annu@igniterminds.com",
		 * "Test123");
		 * 
		 * if(user.getFistName()!=null) { user2.setFistName(user.getFistName()); }
		 * 
		 * if(user.getEmail()!=null) { user2.setEmail(user.getEmail()); }
		 * if(user.getLastName()!=null) { user2.setLastName(user.getLastName()); }
		 */
		return updatedUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId ){
		System.out.println("Delete user is staterted...");
		System.out.println("User id will be deleted is : "+userId);
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			userRepo.deleteById(userId);
			return "User deleted successfully. UserId = "+userId+".";	
		} else {
			return "No such user not found in system.";
		}
	}		
}
