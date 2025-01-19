package com.igniterminds.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igniterminds.models.User;
import com.igniterminds.repositary.UserRepositary;
import com.igniterminds.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepositary userRepo;
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable("userId")Integer id) throws Exception {
		User user = userService.findUserById(id);
		return user;
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User savedUser = userService.registerUser(user);
		return savedUser;
	}
	
	@PutMapping("/users/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable Integer userId ) throws Exception {
		
		User updatedUser = userService.updateUser(user, userId);
		return updatedUser;
		/*
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
		return updatedUser;
		*/
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
	
	@PutMapping("/users/follow/{userId1}/{userId2}")
	public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
		User user = userService.followUser(userId1, userId2);
		return user;
	}
	
	@GetMapping("/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users = userService.serachUser(query);
		return users;
		
	}
	
}
