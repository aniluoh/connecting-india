package com.igniterminds.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.igniterminds.models.Post;
import java.util.List;

public interface PostRepositary extends JpaRepository<Post, Integer>{
	
	@Query("SELECT p FROM post p WHERE p.userId=:userId")
	List<Post> findPostByUserId(Integer userId);
}
