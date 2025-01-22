package com.igniterminds.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igniterminds.models.Post;
import com.igniterminds.models.User;
import com.igniterminds.repositary.PostRepositary;
import com.igniterminds.repositary.UserRepositary;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepositary postRepositary;
	@Autowired
	UserService userService;

	@Override
	public Post createNewPost(Post post,Integer userId) throws Exception {
		
		LocalDate localDate = null;
		Post newPost = new Post();
		User user = userService.findUserById(userId);
		
		newPost.setCaption(post.getCaption());
		newPost.setCreatedDate(localDate.now());
		newPost.setImage(post.getImage());
		newPost.setPostId(post.getPostId());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);

		postRepositary.save(newPost);
		return newPost;
//		return null;
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		
		User user = userService.findUserById(userId);
		
		if (user.getId() != userId){
			throw new Exception("This post does not belongs to the current user.");
		} else {
			postRepositary.delete(post);
		}
		return "Post deleted successfully";
		
//		return null;		
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		List<Post> postList = postRepositary.findPostByUserId(userId);
		return postList;
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		
		Optional<Post> post = postRepositary.findById(postId);
		if(post.isEmpty()) {
			throw new Exception("No such post found with postId : "+postId);
		}
		return post.get();
	}

	@Override
	public List<Post> findAllPost() {
		List<Post> postList = postRepositary.findAll();
		return postList;
	}

	@Override
	public Post savePost(Integer postId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post likePost(Integer postId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
