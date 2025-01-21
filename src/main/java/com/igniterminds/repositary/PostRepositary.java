package com.igniterminds.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igniterminds.models.Post;

public interface PostRepositary extends JpaRepository<Post, Integer>{

}
