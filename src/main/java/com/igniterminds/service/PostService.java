package com.igniterminds.service;

import java.util.List;

import com.igniterminds.models.Post;
import com.igniterminds.models.User;

public interface PostService {
	
	public Post createNewPost(Integer userId) throws Exception;
	
	public void deletePost(Integer postId, User userId) throws Exception;

	public List<Post> findPostByUserId(Integer id);
	
	public Post findPostById(Integer postId) throws Exception;
	
	public List<Post> findAllPost();
	
	public Post savePost(Integer postId, Integer userId);
	
	public Post likePost(Integer postId, Integer userId);
	
}
