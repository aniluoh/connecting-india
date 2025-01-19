package com.igniterminds.service;

import java.util.List;

import com.igniterminds.models.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User findUserById(Integer id) throws Exception;
	
	public User findUserByEmail(String email);
	
	public User followUser(Integer userId1, Integer userId2);
	
	public User updateUser(User user, Integer id) throws Exception;

//	public User unfollowUser(Integer userId1, Integer userId2);
	
	public List<User> serachUser(String query);
	
	
}
