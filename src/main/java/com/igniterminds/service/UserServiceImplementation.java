package com.igniterminds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igniterminds.models.User;
import com.igniterminds.repositary.UserRepositary;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepositary userRepositary;
	
	
	@Override
	public User registerUser(User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFistName(user.getFistName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
		User createdUsed = userRepositary.save(newUser);
		
		return createdUsed;
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		Optional<User> user = userRepositary.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new Exception("User not exists in database with user id : "+id);
	}

	@Override
	public User findUserByEmail(String email) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User followUser(Integer userId1, Integer userId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> findUser = userRepositary.findById(id);
		
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
		
		User updatedUser = userRepositary.save(oldUser);
		return updatedUser;
	}

	@Override
	public List<User> serachUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
