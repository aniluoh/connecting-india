package com.igniterminds.service;

import java.util.List;

import com.igniterminds.models.Post;
import com.igniterminds.models.User;

public interface PostService {
	
	public Post createNewPost(Post post, Integer userId) throws Exception;
	
	public String deletePost(Integer postId, Integer userId) throws Exception;

	public List<Post> findPostByUserId(Integer id);
	
	public Post findPostById(Integer postId) throws Exception;
	
	public List<Post> findAllPost();
	
	public Post savePost(Integer postId, Integer userId) throws Exception;
	
	public Post likePost(Integer postId, Integer userId) throws Exception;
	
}
